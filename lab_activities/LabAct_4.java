import java.util.Scanner;

public class LabAct_4 {
	
	static String[] correctInitialization = {"<data_type>", "<identifier>", "<assignment_operator>", "<value>", "<delimiter>"};
	static String[] correctDeclaration = {"<data_type>", "<identifier>", "<delimiter>"};
	
	public static void main(String[] args) {
		
		/*for testing:
		 * <data_type> <identifier> <assignment_operator> <value> <delimiter>
		 * <data_type> <identifier> <delimiter>
		 */
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
		
		boolean temp = false;
		
		try {
			for(int i = 0; i < tokenSpecific.length; i++) {
				
				if(tokenSpecific[i].matches(correctInitialization[i]))
					temp = true;
				else if (tokenSpecific[i].matches(correctDeclaration[i]))
					temp = true;
				else {
					return false;
				}
					
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			temp = false;
		}
		return temp;
	}
	
	
	
	
	static String getString(String s) {
		
		Scanner input = new Scanner(System.in);
		System.out.print(s);
		String str = input.nextLine();
		return str;
	}

}


/*

static boolean isSyntaxCorrect(String[] tokenSpecific) {

	try {
		for(int i = 0; i < tokenSpecific.length; i++) {
			if(!tokenSpecific[i].matches(correctInitialization[i])) {
				return false;
			}
		}
	}
	catch(ArrayIndexOutOfBoundsException e) {
		return false;
	}
	
	return true;
}
*/
