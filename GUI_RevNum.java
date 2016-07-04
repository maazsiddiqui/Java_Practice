/* Assignment 1

 * Create a class that asks the user for a number. Use a JOptionPane.

 * Create an array of characters (chars) which is of equal size to the
   string that the user input.

 * Using a for loop, check each char in the String that the user input
   to make sure they are all digits. (use the API documentation to see
   which method of class Character that you should use).

 * If any of the characters are not a digit, display an appropriate
   message to the user using another JOptionPane.

 * If all of the characters are digits, display in JoptionPane the number
   in reverse. (hint, use another for loop to create a string of all the
   characters, iterate this for loop backwards).

*/


import javax.swing.JOptionPane;

public class RevNum {

	public static void main(String[] args) {

		String num = JOptionPane.showInputDialog(null, "Please input a number");

		char[] array = new char[num.length()];	// left blank

		// check input for digits/non-digits
		
		for (int i = 0; i < num.length(); i++) { 

			if (!Character.isDigit(num.charAt(i))) {

				JOptionPane.showMessageDialog(null, "Found Non-Digit, Goodbye."); 

				System.exit(0);

			} // end of if

		} // end of for loop

		String rnum = ""; // tried using null but it prints null in output too

		// concatenate each digit for output
		
		for (int j = num.length() - 1; j >= 0; j--) {  

			rnum += num.charAt(j);

		} // end of for loop

		JOptionPane.showMessageDialog(null, rnum); 

	} // end of main

} // end
