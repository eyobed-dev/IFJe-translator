import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    //These are The Tokens The DFA in the main method will choose after reaching final states
    enum Token {
        DIGIT,
        FRACTION,
        SIGN,
        EXPONENT,
        L_PARENTHESIS,
        R_PARENTHESIS,
        COMMA,
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        MODULO,
        POWER,
        TERNARY
    }

    //This is the states of the DFA

    enum State {
        S, I, L, R, C, OP
    }

    //A keyword table to avoid building a lot of states for each keyword(page 15 and 22 of slide 5)
    //It is implemented as Hashmap
    private static final Map<String, Token> Keyword = new HashMap<String, Token>();


    public static void main(String[] args) {


        //Failure if there is no input
        if (args.length == 0) {
            System.err.println("No input. Failure");
            return;
        }

        //add the keywords in at the start of program
        Keyword.put("add", Token.ADD);
        Keyword.put("sub", Token.SUBTRACT);
        Keyword.put("mul", Token.MULTIPLY);
        Keyword.put("div", Token.DIVIDE);
        Keyword.put("mod", Token.MODULO);
        Keyword.put("pow", Token.POWER);
        Keyword.put("tern", Token.TERNARY);



        //Get the first argument which is the input language
        String input = args[0];


        //The final outputs of the DFA is dumped here which is token stream
        //The pushdown automaton will input this
        ArrayList<Token> tokens = new ArrayList<Token>();

        //Read string according to page 10 of slide 5
        String holder = "";

        //State variable initialization
        State currentState = State.S;



        //read characters one by one
        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            switch (currentState) {
                case S:
                    if (Character.isLetter(c)) {
                        holder = holder + c;
                        if (Keyword.containsKey(holder)) {
                            currentState = State.OP;
                            tokens.add(Keyword.get(holder));
                            holder = "";
                        } else {

                        }
                    }
                    if (c == '(') {
                        currentState = State.L;
                        tokens.add(Token.L_PARENTHESIS);

                    }
                    if (c == ')') {
                        currentState = State.R;
                        tokens.add(Token.R_PARENTHESIS);

                    }
                    if (c == ',') {
                        currentState = State.C;
                        tokens.add(Token.COMMA);

                    }
                    if (Character.isDigit(c)) {
                        currentState = State.I;
                        tokens.add(Token.DIGIT);

                    }
            }

            System.out.println("Input: " + input);
            for (Token token : tokens) {
                System.out.println(token.name());
            }

        }
    }