import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LabAct_5 {

	static List<String> expList = new ArrayList<String>(); //this is where we store lexemes of the expression 
	static String expStrSpecific = "";
	
	public static void main(String[] args) {
		
		//Note: This algorithm assumes that the expression is already syntactically correct.
		
		String expression = getInput("Enter Expression: "); //input expression
		char expressionChar; 								//individual char of expression
		boolean quoteSwitch = false; 						//to check strings in quotations
		
		//iterate over whole string
		for(int i = 0; i < expression.length(); i++) {
			
			expressionChar = expression.charAt(i);
			expStrSpecific += expressionChar;
			
			/*Note: I didn't use split(" ") method because if I split the expression via whitespaces,
			 * massplit rin yung may spaces na nasa loob ng quotation marks,
			 * saka hindi massplit yung expression if it's something like (int num=1;) na walang spaces
			 */
			
			//used to add strings in quotation marks to the list
			if(isApostrophe(expressionChar)) {
				if(quoteSwitch==false) quoteSwitch = true;
				else {
					expList.add(expStrSpecific);
					expStrSpecific="";
					quoteSwitch=false;
				}
			}	
			//used to add the other lexemes to the list
			else if(quoteSwitch!=true){
				if(expressionChar == ' ') 		//store data type/
					addStrToList("");
				else if(expressionChar=='=') 	//store identifier to list
					addStrToList("=");
				else if(expressionChar==';') 	//store value to list
					addStrToList(";");
			}
			
		}
		expList.add(expStrSpecific);
		expList.removeAll(Arrays.asList("", null));
		expList.removeAll(Arrays.asList(" ", null));
		
		for(String s : expList)
			System.out.println(s);
		
		String dataType, name, value;
		
		//only for declaration
		if(expList.size() == 3) {
			dataType = expList.get(0);
			name = expList.get(1);
			
			System.out.println("Semantically Correct!");
		}
		//for initialization
		else if (expList.size() > 3){
			dataType = expList.get(0);
			name = expList.get(1);
			value = expList.get(3);
			
			if(semanticCheck(dataType, value)) {
				System.out.println("Semantically Correct!");
			}
			else System.out.println("Semantically Incorrect!");
		}
		else System.out.println("Semantically Incorrect!");
		
		
		
		
		
	}
	
	public static String getInput(String s) {
		
		Scanner input = new Scanner(System.in);
			
		System.out.print(s);
		String temp = input.nextLine();
		System.out.println();
		return temp;
	}
	
	public static void addStrToList(String symbol) {
		
		expList.add(truncLast(expStrSpecific));
		expList.add(symbol);
		expStrSpecific="";
	}
	
	public static boolean semanticCheck(String dataType, String value) {
		
		switch(dataType) {
		case "int":
			if(value.matches("[0-9]+")) 
				return true;
			break;
		case "double":
			if(value.matches("[0-9]+") || value.contains(".")) 
				return true;
			break;
		case "float":
			if(value.matches("[0-9]+") || value.contains(".")) 
				return true;
			break;
		case "char":
			if(value.length() == 3 && value.charAt(0) == '\'' && value.charAt(value.length()-1) == '\'')
				return true;
			break;
		case "String":
			if(value.charAt(0) == '"' && value.charAt(value.length()-1) == '"')
				return true;
			break;
		case "boolean":
			if(value.matches("true") || value.matches("false"))
				return true;
			break;
		default: return false;
		}
		
		return false;
		
	}
	
	public static String truncLast(String s) {
		return s.substring(0, s.length()-1);
	}
	
	public static boolean isApostrophe(char c) {
		if(c == '”' || c == '"' || c == '“') 
			return true;
		else return false;
	}

}
