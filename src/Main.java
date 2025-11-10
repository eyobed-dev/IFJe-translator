import java.util.ArrayList;

public class Main {
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

    }
}