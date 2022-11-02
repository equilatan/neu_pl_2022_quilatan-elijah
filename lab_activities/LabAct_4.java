import java.util.Scanner;

public class LabAct_4 {
	
	static String[] correctSyntax = {"<data_type>", "<identifier>", "<assignment_operator>", "<value>", "<delimiter>"};
	
	public static void main(String[] args) {
		
		//for testing//String token = "<data_type> <identifier> <assignment_operator> <value> <delimiter>";
		String token = getString("Enter Tokens: ");
		String[] tokenSpecific = token.split(" ");
		
		if(isSyntaxCorrect(tokenSpecific)) {
			System.out.println("Syntax is Correct!");
		}
		else {
			System.out.println("Syntax is Error!");
		}

	}
	
	
	static boolean isSyntaxCorrect(String[] tokenSpecific) {

		try {
			for(int i = 0; i < tokenSpecific.length; i++) {
				if(!tokenSpecific[i].matches(correctSyntax[i])) {
					return false;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		
		return true;
	}
	
	
	static String getString(String s) {
		
		Scanner input = new Scanner(System.in);
		System.out.print(s);
		String str = input.nextLine();
		return str;
	}

}
