import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOError;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/*TODO 
Cody:
also added : and = 
and output list
nested comments v
int error catching v 
true/flase v

Xaiver:
strings
main working with input files
*/


public class Main {
    public static void main(String[] args) {
        ArrayList<Token> outputList = new ArrayList<>();
        Lexer l = new Lexer(new InputStreamReader(System.in));
        //Lexer l = new Lexer(new FileReader(new File(args[0])));

        try{
            while (true) { // when comnfiguring to file, need to change this infinate while loop to terminate when end of file 
            Token t = l.yylex();
            if (t == null) {
                break;
            }
            else {
                outputList.add(t);
                //System.out.print(t);
            }   
        } 
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
        }

        // printing list without ,s and []s
        for(int i = 0; i < outputList.size(); i++) {
                System.out.print(outputList.get(i));
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