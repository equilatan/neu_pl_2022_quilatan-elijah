import java.util.Scanner;

public class LabAct_2 {

    public static void main(String args[]){
        String input;
        boolean accepted;

        do{
            input = getString("Input String: ");
        }while(processDFA(input)==false);
    }

    static boolean processDFA(String input){
        String state = "q0";

        for (int i = 0; i < input.length(); i++){
            //q0
            if(state.equals("q0") && input.charAt(i)=='0')
                state="q1";
            else if(state.equals("q0") && input.charAt(i)=='1')
                state="q0";
            //q1
            else if(state.equals("q1") && input.charAt(i)=='0')
                state="q1";
            else if(state.equals("q1") && input.charAt(i)=='1')
                state="q2";
            //q2
            else if(state.equals("q2") && input.charAt(i)=='0')
                state="q1";
            else if(state.equals("q2") && input.charAt(i)=='1')
                state="q0";
            //invalid input
            else{
                System.out.println("Invalid Input.");
                tryAgain();
                return false;
            }

        }

        if(state.equals("q2")){
            System.out.println("String accepted");
            return true;
        }
        else {
            System.out.println("String not accepted. ");
            tryAgain();
            return false;
        }

    }

    static void tryAgain(){
        char yesOrNo = getString("Would you like to input another string? [y/n]: ").charAt(0);
        switch(yesOrNo){
            case 'y' : System.out.println(); break;
            case 'n' : System.exit(0); break;
            default :System.exit(0); break;
        }
    }

    static String getString(String s) {
        System.out.print(s);
        return new Scanner(System.in).nextLine();
    }
}
