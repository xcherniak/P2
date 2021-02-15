public enum Tok {
    //Have to add the entire offical list of tokens from project specs
    PLUS("plus"),                
    MINUS("minus"),             
    TIMES("times"),             
    DIVIDE("divide"),           
    LPAREN("lparen"),           
    RPAREN("rparen"),           
    COMMA("comma"),             
    IDENTIFIER("identifier"),   
    INT("int"),         
    AT("at"),                   
    CASE("case"),               
    CLASS("class"),              
    COLON("colon"),             
    DOT("dot"),                 
    ELSE("else"),
    EQUALS("equals"),
    ESAC("esac"),
    FALSE("false"),
    FI("fi"),
    IF("if"),
    IN("in"),
    INHERITS("inherits"),
    ISVOID("isvoid"),
    LARROW("larrow"),
    LBRACE("lbrace"),
    LE("le"),
    LT("lt"),
    LET("let"),
    LOOP("loop"),
    IT("it"),
    NEW("new"),
    NOT("not"),
    OF("of"),
    POOL("pool"),
    RARROW("rarrow"),
    RBRACE("rbrace"),
    SEMI("semi"),
    STRING("string"),
    THEN("then"),
    TILDE("tilde"),
    TRUE("true"),
    TYPE("type"),
    WHILE("while");

    


    //Not sure if we need this we don't
    //FLOAT("float");

    private final String name;

    private Tok(String s) {
        name = s;
    }

    public String toString() {
        return name;
    }
}
