import java.io.*;
import java.util.Scanner; // required to get input from file

public class bucketSort {

	private int[] hashTable; // 1D dynamic array
	private String inFile; // input file
	private String outFile; // output file
	
	bucketSort(String in, String out) {  // Constructor

		inFile = in;
		outFile = out;
		int size;
		
		try {
			size = (findMax() + 1);
		
			hashTable = new int[size];

			for (int n = 0; n < size; n++) { // set all array positions to zero
				hashTable[n] = 0;
			}
		
			startSort(); // bucket sorting starts
			outToFile(); // output to file
		}
		
		catch (IOException e) {
			System.out.println(e.getMessage());	
		}
		
	} // end of constructor
	
	
	void startSort() throws IOException {
		
		Scanner dataFile = new Scanner(new File(inFile));
		
		while (dataFile.hasNextInt()) {
			int index = hashforBucketSort(dataFile.nextInt());
			hashTable[index]++;
		}
		
		dataFile.close(); // input file closed
	}
	
	
	int hashforBucketSort(int n) {
		return n;	//identity function
	}
	
	
	int findMax() throws IOException {
		
		Scanner dataFile = new Scanner(new File(inFile));
		
		int maxBucket = 0;
		
		while (dataFile.hasNextInt()) {				
			int current = dataFile.nextInt();
			if (maxBucket < current) maxBucket = current;
		}
		
		dataFile.close(); // input file closed
			
		return maxBucket;
	}
	
	
	void outToFile() throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter(outFile)); // opening output file
		
		out.print("Data Sorted using Bucket Sort: ");
		
		for (int j = 0; j < hashTable.length; j++) {
			
			while (hashTable[j] > 0) {
				
				out.print(j + " ");
				hashTable[j]--;
				
			}
			
		}
		
		out.close(); // output file closed

		return;

	}
}
