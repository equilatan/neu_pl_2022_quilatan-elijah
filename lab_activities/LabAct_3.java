import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LabAct_3 {

    public static void main(String[] args){

        System.out.print("Input single line code: ");
        String input = new Scanner(System.in).nextLine();

        String inputChar="";
        boolean strChk=false;

        List<String> lexeme = new ArrayList<String>();
        List<String> token = new ArrayList<String>();

        //iterate each character from the string input
        for(int i=0; i<input.length(); i++){

            inputChar+=input.charAt(i);

            //checks if the string is in quotation marks
            if(isApostrophe(input.charAt(i))) {
                strChk = toggleBool(strChk);
            }

            //if the string is not in quotation, do this
            if(strChk!=true) {

                //splits the string before equals and semicolon
                if(input.charAt(i)=='=' || input.charAt(i)==';') {
                    lexeme.add(inputChar.substring(0, inputChar.length() - 1));
                    lexeme.add("" + input.charAt(i));
                    inputChar="";
                }
                //splits the string for every whitespace
                else if(input.charAt(i)==' ') {
                    lexeme.add(inputChar.replaceAll("\\s+$", ""));
                    inputChar="";
                }

            }
        }
        //to make sure the last string is added in the arraylist
        lexeme.add(inputChar.replaceAll("\\s+$", ""));
        //remove all empty strings in the arraylist
        lexeme.removeAll(Arrays.asList("", null));


        //categorizes the lexemes into their respective tokens
        for(String lex : lexeme) {
            if(isDataType(lex)) {
                token.add("<data_type> ");
            }
            else if(isAssnOperator(lex)) {
                token.add("<assignment_operator> ");
            }
            else if(isValue(lex)) {
                token.add("<value> ");
            }
            else if(isIdentifier(lex)) {
                token.add("<identifier> ");
            }
            else if(lex.matches(";")) {
                token.add("<delimiter> ");
            }
        }

        //print the tokens in order
        for(String s : token) {
            System.out.print(s + " ");
        }

    }

    //methods used for categorizing/checking

    public static boolean toggleBool(boolean b) {
        if(b==true) return false;
        else return true;
    }

    private static boolean isApostrophe(char c) {

        if(c=='“' || c=='”' || c=='\"' || c=='\'') {
            return true;
        }
        return false;
    }

    private static boolean isValue(String s) {
        if(s.contains("“") || s.contains("”") || s.contains("\"") || s.contains("\'") || s.matches("[0-9]*\\.?[0-9]*")) {
            return true;
        }
        return false;
    }

    private static boolean isIdentifier(String s) {

        if(s.matches("^[a-zA-Z0-9_.-]*$") && (!s.contains("\"") || !s.contains("\'") || !s.matches("[0-9]*\\.?[0-9]*")))
            return true;
        return false;
    }

    public static boolean isDataType(String s){

        String[] dataType = {"int","double","char","String"};

        for(String dType : dataType){
            if(s.contentEquals(dType))
                return true;
        }
        return false;
    }

    public static boolean isAssnOperator(String s) {

        if(s.matches("=")) {
            return true;
        }
        return false;
    }
}
