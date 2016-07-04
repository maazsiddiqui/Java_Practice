import java.io.*;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {

		if (args.length != 4) {
			System.out.println("Improper command line arguments.");
			return;
		}

		Scanner dataFile = new Scanner(new File(args[0]));
		int totalNodes = dataFile.nextInt();
		
		dijktraSSS mySSS = new dijktraSSS(totalNodes);

		while (dataFile.hasNextInt()) {
			mySSS.setCostMatrix(dataFile.nextInt()-1, dataFile.nextInt()-1, dataFile.nextInt());
        }
		
		dataFile.close(); // input file closed
				
		mySSS.makeZeroUnlimited();
		mySSS.printCostMatrix(args[3]);
		
		for (int i = 0; i < totalNodes; i++) {
			
			Scanner dataFile2 = new Scanner(new File(args[1]));
			int current = dataFile2.nextInt();
			dataFile2.close(); // input file closed
			
			mySSS.startDijktraSSS(current, args[2], args[3]);
		
			PrintWriter out = new PrintWriter(new FileWriter(args[1]));
			out.print(Integer.toString(current+1));
			out.close(); // output file closed
		}
	}
}
