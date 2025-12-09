public enum TokenType{
    // Function identifiers
    ADD, SUB, MUL, DIV, MOD, POW, TERN,

    // Literals
    NUMBER,

    // Single-character tokens
    LEFT_PAREN, RIGHT_PAREN, COMMA,

    // End of file
    EOF,

    // Invalid token
    UNKNOWN
}
