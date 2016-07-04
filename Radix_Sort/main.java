import java.io.*;
import java.util.Scanner;


public class main {

	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.out.println("Improper command line arguments.");
			return;
		}

		Scanner dataFile = new Scanner(new File(args[0]));

		int totalDigit = 0; 
		LLStack myStack = new LLStack();
		
		while (dataFile.hasNextLine()) {
			
			String line = dataFile.nextLine();

			Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(" ");
			
            while (lineScanner.hasNext()) {
            	
            	String dummy = lineScanner.next();
            
            	if (totalDigit < dummy.length()) totalDigit = dummy.length();
            	myStack.push(dummy);
			
            }
            
            lineScanner.close();
		}
		
		dataFile.close(); // input file closed

		myStack.printToFile(args[1]);
			
		RadixSort rs = new RadixSort(myStack, totalDigit, args[1]);
			
		rs.printResult();
	}

}
