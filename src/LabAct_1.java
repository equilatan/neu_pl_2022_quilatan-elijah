import java.util.Scanner;

public class LabAct_1 {

        public static void main(String args[])
        {
            String inputStr = getString("Enter word/phrase: ");

            if(isPalindrome(inputStr))
                System.out.println(inputStr + " is a palindrome");
            else
                System.out.println(inputStr + " is NOT a palindrome");

        }

        static boolean isPalindrome(String str) {

            //converts string input to lowercase, then removes all whitespace and special characters.
            str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

            //iterates string input comparing characters from first and last places
            for(int i=0, j=str.length() ; j > 0 ; i++, j--)
                if((str.charAt(i)!=str.charAt(j-1)))
                    return false;

            return true;
        }

        static String getString(String s) {
            System.out.print(s);
            return new Scanner(System.in).nextLine();
        }
    }


/*
	static boolean isPalindrome(String str) {

		str= str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		//converts user input to lowercase, then removes all whitespace and special characters. instruction didn't mention to ignore numbers so I kept it in.

		char[] arr = str.toCharArray(); //convert string input to char array

		if(Arrays.equals(arr, reverseArr(arr))) //check if the array is equal to its reversed self.
			return true;
		else
			return false;

	}

	static char[] reverseArr(char[] arr) {

		char[] temp = new char[arr.length];

		for(int i=0, j=arr.length ; j>0; i++,j--) //iterates the array backwards and sets value to temp.
			temp[i] = arr[j-1];

		return temp;

	}
	*/

