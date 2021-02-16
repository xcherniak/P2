import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOError;
import java.io.File;
import java.io.FileReader;

/*TODO 
Cody:
nested comments 
int error catching
true/flase
Xaiver:
strings
main working with input files
*/


public class Main {
    public static void main(String[] args) {
        ArrayList<Token> tokList = new ArrayList<>();
        
        //Lexer l = new Lexer(new InputStreamReader(System.in));
        try {Lexer l = new Lexer(new FileReader(new File(args[0])));
        


            try{
                while (true) {
                    Token t = l.yylex();
                    if (t == null) {
                        break;
                    }
                    else {
                        tokList.add(t);
                    }   
                }
            //If we get here there were no errors Print out our token list
                for (int i=0; i<tokList.size();i++) {
                    System.out.println(tokList.get(i));
                } 
            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
            }
        }
        catch (IOException e){
            System.err.println(e.getLocalizedMessage());
        }    
    }
}

