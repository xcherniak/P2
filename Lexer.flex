// Section one 

%%

// Section two ... options and declare constants
%class Lexer     // Name of the class to produce with this flex def
%unicode         // Defines the charset
%line            // Switch on line counting
%column
%type Token      // specify the return of the tokens

%{
    //Use those functions to create tokens
    //Also got rid of column here because we only need line
    private Token token(Tok type) {
        return new Token(type, yyline+1);
    }

    private Token token(Tok type, Object value) {
        return new Token(type, yyline+1, value);
    }

    int commentCount = 0;

%}

// macro/constants regex for different token types
Identifier = [a-z][_A-Za-z0-9]*
IntegerLiteral = [0-9]+

// true or false

Whitespace = [ \t\n]
Comment = "--".*[\n]

Type = [A-Z][_A-Za-z0-9]*


%state STRING
%state COMMENT



%%

//section three .. lexical analysis rules
<YYINITIAL> {
"+"                 { return token(Tok.PLUS); }
"-"                 { return token(Tok.MINUS); }
"*"                 { return token(Tok.TIMES); }
"/"                 { return token(Tok.DIVIDE); }
","                 { return token(Tok.COMMA); }
"("                 { return token(Tok.LPAREN); }
")"                 { return token(Tok.RPAREN); }
"@"                 { return token(Tok.AT);}
"<-"                { return token(Tok.LARROW);}
"{"                 { return token(Tok.LBRACE);}
"<="                { return token(Tok.LE);}
"<"                 { return token(Tok.LT);}
"=>"                { return token(Tok.RARROW);}
"}"                 { return token(Tok.RBRACE);}
";"                 { return token(Tok.SEMI);}
"~"                 { return token(Tok.TILDE);}
"."                 { return token(Tok.DOT);}
"class"             { return token(Tok.CLASS);} 
"else"              { return token(Tok.ELSE);}
"fi"                { return token(Tok.FI);}
"if"                { return token(Tok.IF);}
"in"                { return token(Tok.IN);}
"inherits"          { return token(Tok.INHERITS);}
"isvoid"            { return token(Tok.ISVOID);}
"let"               { return token(Tok.LET);}
"loop"              { return token(Tok.LOOP);}
"pool"              { return token(Tok.POOL);}
"then"              { return token(Tok.THEN);}
"while"             { return token(Tok.WHILE);}
"case"              { return token(Tok.CASE);}
"esac"              { return token(Tok.ESAC);}
"new"               { return token(Tok.NEW);}
"of"                { return token(Tok.OF);}
"not"               { return token(Tok.NOT);}
"t"(r|R)(u|U)(e|E)  { return token(Tok.TRUE);}
"f"(a|A)(l|L)(s|S)(e|E) { return token(Tok.FALSE);}
":"                 { return token(Tok.COLON);}
"="                 { return token(Tok.EQUALS);}

"(*".*              { commentCount = 1; yybegin(COMMENT);}


//string
"\""                { yybegin(STRING);}



{Identifier}        { return token(Tok.IDENTIFIER, yytext()); }
{IntegerLiteral}    { 
                        try {
                            Integer.parseInt(yytext());
                        } catch(Exception x) {
                            System.out.println("ERROR: " + yyline+1 + " Lexer: too large int " + yytext());
                            System.exit(1);
                        }
                        return token(Tok.INT, yytext()); 
                    } 
{Type}              { return token(Tok.TYPE, yytext()); }

{Whitespace}        { /* ignore */ }




}
/*
//create a string state
<STRING> {
    //Watch the class video about the string.toString() part. Not entirely sure how or if that works
    //I also don't know if all of this has to be in unicode?
    "\""                           { yybegin(YYINITIAL); return token(Tok.STRING); } //This line I am not 100% sure about
    [^\n\r\"\\\0]+               { string.append( yytext() ); }
    \\t                          { return token(Tok.ERROR);}
    [\u000A]                      {  } // make error
    [\u0000]                   { } // make error
    \\r                         {  } // make error
    \\\"                         { string.append('\"'); } // took out quote after \\\
    \\                             { string.append('\\'); }
}
*/


<COMMENT> {
    "(*".*                            { commentCount++; } // .* allows for (*comment 
    
    "*)"                            {commentCount--;
                                    if (commentCount == 0) 
                                        yybegin(YYINITIAL);}

    [^]                             { /*ignore*/ }                           
}



    [^] {System.out.println("ERROR: " + yyline+1 + " Lexer: invalid character: " + yytext()); 
        System.exit(1);}

