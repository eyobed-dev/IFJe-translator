import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Scanner {

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

    //Keyword table
    private static final Map <String, Token> keywords = Map.of(
            "add", Token.ADD,
            "sub", Token.SUB,
            "mul", Token.MUL,
            "div", Token.DIV,
            "mod", Token.MOD,
            "pow", Token.POW,
            "tern", Token.TERN
    );

    private String input;

    public Scanner(String input) {
        this.input = input;
    }





}