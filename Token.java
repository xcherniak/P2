// I removed col(column) from the entire program becasue it doesn't look like we need it based on the desired output
public class Token {
    private Tok tokType; // enum type
    private int line;
    private Object value; // associated lexeme


    public Token(Tok tokType, int line) {
        this.tokType = tokType;
        this.line = line;
    }

    public Token(Tok tokType, int line, Object value) {
        this(tokType, line);
        this.value = value;
    }

    // toString method so we can print out tokens
    // Change this to print out the desired output
    public String toString() {
        //This line makes the first two lines which are row num and the name
        String toReturn = this.line + "\n" + this.tokType + "\n" ;

        //This checks to see if there is a value which should only happen in 4 cases (string, identifiers, integers, strings and types)
        if (value != null) {
            toReturn = toReturn + value.toString() + "\n";
        }

        return toReturn;
    }
}