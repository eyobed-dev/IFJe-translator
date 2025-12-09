import java.util.*;

// the implementation of the automata
public class Scanner {

    //state of the automata
    private enum State {
        START,
        LETTER,
        NUMBER,
        SIGN,
        DOT,
        FRACTION,
        EXPONENT,
        EXPONENT_SIGN,
        SLASH,
        COMMENT,
        COMMENT_END,

        //Final States
        LEFT_PAREN,
        RIGHT_PAREN,
        COMMA,
        FUNCTION,
        FP_NUMBER

    }

    //Keyword table according to recommendation from slide 10
    Map<String, TokenType> keywords = Map.of(
            "add", TokenType.ADD,
            "sub", TokenType.SUB,
            "mul", TokenType.MUL,
            "div", TokenType.DIV,
            "mod", TokenType.MOD,
            "pow", TokenType.POW,
            "tern", TokenType.TERN
    );

    // final not changing string to hold input
    private final String input;

    //this is tapereader input of dfa
    private int readHead = 0;

    //holder for concatnation
    private String str = "";

    public Scanner(String input) {
        this.input = input;
    }

    public List<Token> scan() {
        List<Token> tokens = new ArrayList<>();
        Token token;
        do {
            token = getNextToken();
            tokens.add(token);
        }
        while (Objects.requireNonNull(token).type != TokenType.EOF);
        return tokens;
    }


    //Implementation of the DFA
    private Token getNextToken() {
        str = "";
        if (readHead == input.length()) {
            return new Token(TokenType.EOF, "");
        }

        State state = State.START;

        //we now begin switching of state final states are mostly useless and added here for completness and understanding
        while (readHead < input.length()) {
            char c = input.charAt(readHead);

            switch (state) {
                case START:
                    if (Character.isWhitespace(c) || c == '\n' ) {
                        readHead++;
                        continue;
                    } else if (c == '/') {
                        state = State.SLASH;
                        readHead++;
                        continue;
                    } else if (c == '(') {
                        state = State.LEFT_PAREN;
                        readHead++;
                        return new  Token(TokenType.LEFT_PAREN, "(");
                    } else if (c == ')') {
                        state = State.RIGHT_PAREN;
                        readHead++;
                        return new   Token(TokenType.RIGHT_PAREN, ")");
                    } else if (c == ',') {
                        state = State.COMMA;
                        readHead++;
                        return new Token(TokenType.COMMA, ",");
                    } else if (Character.isLetter(c)) {
                        state = State.LETTER;
                        str += c;
                        readHead++;
                        continue;
                    } else if (Character.isDigit(c)) {
                        str += c;
                        state = State.NUMBER;
                        readHead++;
                        continue;
                    } else if (c == '+' || c == '-') {
                        str +=c;
                        state = State.SIGN;
                        readHead++;
                        continue;
                    } else {
                        throw new RuntimeException("Failure. Unknown state: " + state);
                    }

                case LETTER:
                    if (Character.isLetter(c)) {
                        str += c;
                        readHead++;
                        continue;
                    } else {
                        if (!keywords.containsKey(str)) {
                            throw new RuntimeException("Failure. Unknown function: " + str);
                        } else {
                            state = State.FUNCTION;
                            return new Token (keywords.get(str), str);

                        }
                    }

                case SIGN:
                    if (Character.isDigit(c)) {
                        str += c;
                        state = State.NUMBER;
                        readHead++;
                        continue;
                    }
                case NUMBER:
                    if (Character.isDigit(c)) {
                        str += c;
                        readHead++;
                        continue;
                    } else if (c == '.') {
                        str += '.';
                        state = State.DOT;
                        readHead++;
                        continue;
                    } else if (c == 'e' || c == 'E') {
                        str += 'e';
                        state = State.EXPONENT;
                        readHead++;
                        continue;
                    } else {
                        return new Token(TokenType.NUMBER,str);

                    }
                case SLASH:
                    if (c == '*') {
                        state = State.COMMENT;
                        readHead++;
                        continue;
                    }else{
                        throw new RuntimeException("Failure. Unrecognized character: /");
                    }
                case DOT:
                    if(Character.isDigit(c)) {
                        str += c;
                        state = State.FRACTION;
                        continue;
                    }
                case EXPONENT:
                    if (Character.isDigit(c)) {
                        state = State.FP_NUMBER;
                        readHead++;
                        continue;
                    } else if ( c == '+' || c == '-') {
                        state = State.EXPONENT_SIGN;
                        readHead++;
                        continue;

                    }
                case EXPONENT_SIGN:
                    if (Character.isDigit(c)) {
                        state = State.FP_NUMBER;
                        readHead++;
                        continue;
                    }
                case FRACTION:
                    if (Character.isDigit(c)) {
                        str += c;
                        state = State.FRACTION;
                        readHead++;
                        continue;
                    } else if (c == 'e' || c == 'E') {
                        str += 'e';
                        state = State.EXPONENT;
                        readHead++;
                        continue;
                    }else{
                        state = State.FP_NUMBER;
                        return new Token(TokenType.NUMBER,str);
                    }
                case COMMENT:
                    if(c == '*'){
                        state = State.COMMENT_END;
                        readHead++;
                        continue;
                    } else {
                        readHead++;
                    }
                case COMMENT_END:
                    if( c == '/'){
                        state = State.START;
                        readHead++;
                        continue;
                    } else if (c == '*') {
                        state = State.COMMENT;
                        readHead++;

                    }
            }
        }

        return null;
    }


}