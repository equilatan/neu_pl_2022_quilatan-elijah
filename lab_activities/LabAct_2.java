public class LabAct_2 {

    public static void main(String args[]){

        String state = "q0";
        String input = "01111110101010100001";

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
                state="q2";
        //invalid input
            else{
                System.out.println("Invalid Input. Exiting automaton...");
                break;
            }

        }

        if(state.equals("q2"))
            System.out.println("String accepted");
        else
            System.out.println("String not accepted.");
    }
}
