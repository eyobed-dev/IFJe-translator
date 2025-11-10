import java.util.HashMap;
import java.util.Map;

//These are The Tokens The DFA in the main method will choose after reaching final states
public enum Token {
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
        private static final Map<String, Token> Keyword = new HashMap<String, Token>();
