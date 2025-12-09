import java.util.List;

public class Main {
    public static void main(String[] args) {

        // fail if there is no input
        if (args.length == 0) {
            System.err.println("No input. Failure");
            return;
        }
        String input = "";

        // Get the all argument which is the input language
        for (String arg : args) {
            input += arg;
        }

        // Lexical Analysis
        Scanner scanner = new Scanner(input);
        List<Token> tokens = scanner.scan();

        // debug
        // System.out.println("Tokens: " + tokens);

        // Syntax Analysis
        Parser parser = new Parser(tokens);
        Tree tree = Parser.parse();
        // debug
        // System.out.println("Parse Tree: " + tree);

        // Code Generation
        CodeGeneration codeGen = new CodeGeneration(tree);
        String output = codeGen.generate();

        System.out.println(output);

    }
}