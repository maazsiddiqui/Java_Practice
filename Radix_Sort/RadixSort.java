import java.io.*;

public class RadixSort {
	
	private int currentTable;
	private int previousTable;
	private int totalDigit;
	private int index;
	private hashTable[] HT;
	private LLStack Stack;
	private String outFile; // pointer to args[1]
	
	RadixSort(LLStack myStack, int maxDigit, String printFile) throws IOException {
		
		totalDigit = maxDigit;
		previousTable = 0;
		currentTable = 0;
		index = 0;
		outFile = printFile;
		Stack = myStack;
		HT = new hashTable[2];
		
		HT[0] = new hashTable();
		HT[1] = new hashTable();
		
		
		startSorting();
		
	}

	void startSorting() throws IOException {
		
		while (Stack.isEmpty() != true) {
			addtoHash(Stack.pop());
		}
		
		PrintWriter out = new PrintWriter(new FileWriter(outFile, true)); // opening output file
		out.println();
		out.println();
		out.close();
		
		printhashTable(getcurrentTable());

		PrintWriter out1 = new PrintWriter(new FileWriter(outFile, true)); // opening output file
		out1.println();
		out1.close();
		
		currentTable = 1;
		
		while (index < totalDigit) {

			TabletoTable();

			PrintWriter out2 = new PrintWriter(new FileWriter(outFile, true)); // opening output file
			out2.println("Previous Table");
			out2.println();
			out2.close();
			
			printhashTable(getpreviousTable());
			
			PrintWriter out3 = new PrintWriter(new FileWriter(outFile, true)); // opening output file
			out3.println();
			out3.close();

		}
		
		currentTable = previousTable;

		PrintWriter out4 = new PrintWriter(new FileWriter(outFile, true)); // opening output file
		out4.println("Current Table");
		out4.println();
		out4.close();
		
		printhashTable(getcurrentTable());
		
		PrintWriter out5 = new PrintWriter(new FileWriter(outFile, true)); // opening output file
		out5.println();
		out5.close();

	}


	void addtoHash(String a) {
		
		int currentDigit = a.length() - index;
		if (currentDigit <= 0) {
			HT[currentTable].getArray(hash(0)).addTail(a);
		}
		else
			HT[currentTable].getArray(hash((a.charAt(currentDigit-1) - '0'))).addTail(a);
		return;
	}

	void TabletoTable() {
			
		for (int i = 0; i < 10; i++) {
		
			while (HT[previousTable].getArray(i).isEmpty() != true) {
			
				String in = HT[previousTable].getArray(i).deleteHead();
				addtoHash(in);

			}	
		
		}

		int temp = currentTable;
		currentTable = previousTable;
		previousTable = temp;
		
		index++;	
	}

	void printhashTable(int a) throws IOException {	
		HT[a].printFileTable(outFile);
		return;
	}

	// Getters

	int getcurrentTable() {
		return currentTable;
	}

	int getpreviousTable() {
		return previousTable;
	}

	int gettotalDigit() {
		return totalDigit;
	}

	int getindex() {
		return index;
	}

	// Setters

	void setcurrentTable(int a) {
		currentTable = a;
		return;
	}

	void setpreviousTable(int a) {
		previousTable = a;
		return;
	}

	void settotalDigit(int a) {
		totalDigit = a;
		return;
	}

	void setindex(int a) {
		index = a;
		return;
	}

	int hash(int a) {
		if (a > 0) return a;
		else return 0;
	}


	void printResult() throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter(outFile, true)); // opening output file
		
		out.print("Result: ");
		
		for (int i = 0; i < 10; i++) {
			
			while (HT[previousTable].getArray(i).isEmpty() != true) {
			
				String in = HT[previousTable].getArray(i).deleteHead();
				out.print(in + " ");
			}	
		}
		
		out.close();
		
		return;
		
	}


}
