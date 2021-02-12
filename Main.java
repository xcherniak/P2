import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Lexer l = new Lexer(new InputStreamReader(System.in));

        try{
            while (true) {
            Token t = l.yylex();
            if (t == null) {
                break;
            }
            else {
                // FIXME This is where we want to make the print come out
            }   
        } 
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }

        
    }
}

/**
 * Things Still needed to be done
 * -Turn our lex things into a file
 * -The error checking he wants done.
 * -Adding in types. I am not 100% sure what to do for those
 * -Finishing up string
 * -There are prolly more I am just not thinking of lol
 * -True and False still need more done because they don't work the same as all the other keywords
 */
