import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    //This is the states of the DFA

    enum State {
        S, I, L, R, C, OP
    }

    //A keyword table to avoid building a lot of states for each keyword(page 15 and 22 of slide 5)
    //It is implemented as Hashmap


    public static void main(String[] args) {

        //Failure if there is no input
        if (args.length == 0) {
            System.err.println("No input. Failure");
            return;
        }

        //Get the first argument which is the input language
        String input = args[0].trim();

        // Lexical Analysis
        Scanner scanner = new Scanner(input);
        ArrayList<Token> tokens = scanner.scan();

        System.out.println("Tokens: " + tokens);

        //Syntax Analysis
        Parser parser = new Parser(tokens);
        String output = parser.parse();

        System.out.println(output);


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