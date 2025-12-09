public class CodeGeneration {

    //holder for input from the parser
    Tree tree;

    //constructor
    public CodeGeneration(Tree tree) {
        this.tree = tree;
    }

    //generate the output
    public String generate() {
        return generateOutput(tree, 0);
    }

    //generate the output recursively
    private String generateOutput(Tree tree, int parentPrecedence) {

        //if it is a number
        if (tree.left == null || tree.right == null) {
            return tree.value;
        }

        //get the precedence and symbol of the operator
        int precedence = getPrecedence(tree.value);
        String symbol = getSymbol(tree.value);

        //check if we need parentheses that is if the precedence is less than the parent precedence
        boolean parentheses = precedence < parentPrecedence;

        //holder for the output
        String output = "";

        //add parentheses if needed
        if (parentheses) {
            output += "(";
        }

        //ternary operator special case
        if (tree.value.equals("tern")) {
            output += generateOutput(tree.left, precedence);
            output += "?";
            output += generateOutput(tree.right, precedence);
            output += ":";
            output += generateOutput(tree.third, precedence);
        } else {
            output += generateOutput(tree.left, precedence);
            output += symbol;
            output += generateOutput(tree.right, precedence);
        }

        //add parentheses if needed
        if (parentheses) {
            output += ")";
        }

        return output;
    }

    //get the precedence of the operator
    private int getPrecedence(String value) {
        switch (value) {
            case "tern":
                return 1;
            case "add":
            case "sub":
                return 2;
            case "mul":
            case "div":
            case "mod":
                return 3;
            case "pow":
                return 4;
            default:
                return 99;
        }
    }

    //get the symbol of the operator
    private String getSymbol(String value) {
        switch (value) {
            case "add":
                return "+";
            case "sub":
                return "-";
            case "mul":
                return "*";
            case "div":
                return "/";
            case "mod":
                return "%";
            case "pow":
                return "^";
            default:
                return "";
        }
    }
}
