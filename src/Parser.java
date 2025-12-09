import java.util.List;

// The implementation of the parser
public class Parser {


    //holder for input from the scanner
    static List<Token> tokens;


    //position of the current token
    static int pos;

    //constructor
    public Parser(List<Token> tokens) {
        Parser.tokens = tokens;
    }


    //parse the input to return a parse tree
    public static Tree parse() {
        pos = 0;
        return parseexpression();
    }

    //Implementation of recursive descent parser
    public static Tree parseexpression() {
        Token token = tokens.get(pos);
        pos++; //Get the next token

        if (checkfunction(token.value)) {
            Tree tree = new Tree(token.value);

            pos++; //eat the (

            tree.left = parseexpression(); //parse the first expression

            pos++; //eat the comma

            tree.right = parseexpression(); //parse the second expression


            //exception for ternary
            if (token.value.equals("tern")) {

                pos++; //eat the second comma

                tree.third = parseexpression(); //parse the third expression


            }

            pos++; // eat the last )

            return tree;

        } else {
            return new Tree(token.value);//just a number
        }

    }


    //helper 

    static boolean checkfunction(String t) {

        return t.equals("add") || t.equals("sub") || t.equals("mul") || t.equals("div") || t.equals("mod")
                || t.equals("pow") || t.equals("tern");
    }
}


