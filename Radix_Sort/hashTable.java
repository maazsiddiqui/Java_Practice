import java.io.*;

public class hashTable {
	
	private LLQueue[] array;
	private String outFile; // pointer to args[1]
	
	hashTable() {
		
		array = new LLQueue[10];
		
		for (int i = 0; i < 10; i++) {
			array[i] = new LLQueue(); 
		}
	}


	void printTable() {
		for (int i = 0; i < 10; i++) {
			System.out.print("index " + i + '\t' + '\t');
			array[i].printQueue();
			System.out.println();		
		}

	}

	
	LLQueue getArray(int x) {
		return array[x];
	}

	void printFileTable(String outputFile) throws IOException {

		outFile = outputFile;
		
		for (int i = 0; i < 10; i++) {
			PrintWriter out = new PrintWriter(new FileWriter(outFile, true));
			out.println();
			out.print("index " + i + " ");
			out.close();
			array[i].printFileQueue(outputFile);		
		}	
		
		PrintWriter out = new PrintWriter(new FileWriter(outFile, true));
		out.println();
		out.close();
		
	}
		

}