
public class LabAct_4 {

	public static void main(String[] args) {
		
		String token = "<data_type> <identifier> <assignment_operator> <value> <delimiter>";
		
		String[] tokenSpecific = token.split(" ");
		
		if(isSyntaxCorrect(tokenSpecific)) {
			System.out.println("Syntax is Correct!");
		}
		else {
			System.out.println("Syntax is Error!");
		}

	}
	
	static String[] correctSyntax = {"<data_type>", "<identifier>", "<assignment_operator>", "<value>", "<delimiter>"};
	
	static boolean isSyntaxCorrect(String[] tokenSpecific) {
		
		for(int i = 0; i < tokenSpecific.length; i++) {
			if(!tokenSpecific[i].matches(correctSyntax[i])) {
				return false;
			}
		}
		return true;
	}

}
