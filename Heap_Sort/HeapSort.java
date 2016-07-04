import java.io.*;

public class HeapSort {
	
	private int[] pArray; // dynamic array
	private int size; // array size
	private String inputFile; // pointer to argv[0]
	private String outFile; // pointer to argv[1]
		
	HeapSort(int a, String i, String o) throws IOException {  // Constructor

		size = a;
		pArray = new int[size];
		inputFile = i;
		outFile = o;

		for (int n = 0; n < size; n++) { // set all array positions to zero
			pArray[n] = 0;
		}
		
		buildHeap();
	}

	void buildHeap() throws IOException {

		FileReader theFile;
		BufferedReader inFile;
		String oneline;
		
		theFile = new FileReader(inputFile);
		inFile = new BufferedReader(theFile);
		
		PrintWriter out = new PrintWriter(new FileWriter(outFile));
		
		out.println("Build Heap :");
		
		while(((oneline = inFile.readLine()) != null) && !isHeapFull()) {
			
			if (oneline.length() > 0) {
			
				String line1[] = oneline.split(" ");
				for(int i = 0; i < line1.length; i++) {
					insertOneDataItem(Integer.parseInt(line1[i])); // taking ints from input file and inserting in heap array
					out.println("Insert " + Integer.parseInt(line1[i]) + '\t' + printHeap(10));
				}
			
			}
			
		}
		
		inFile.close(); // input file closed
		
		out.println('\n' + "Final Heap :" + '\n' + printHeap(size) + '\n');
		
		out.close(); // output file closed

		return;

	}

	void insertOneDataItem(int a) {
		
		pArray[0]++;
		pArray[pArray[0]] = a;
		bubbleUp();

		return;

	}

	void bubbleUp() {

		int current = pArray[0];

		while ((current / 2 > 0) && (pArray[current / 2] > pArray[current])) {

			int temp = pArray[current / 2];
			pArray[current / 2] = pArray[current];
			pArray[current] = temp;
			current = current / 2;
		}

		return;

	}

	boolean isHeapFull() {

		if (pArray[0] == size - 1) return true;

		return false;

	}

	boolean isHeapEmpty() {

		if (pArray[0] <= 0) return true;

		return false;

	}

	String printHeap(int a) {

		String s = "";
		
		for (int j = 1; j <= pArray[0] && j <= a; j++) {
			s += pArray[j] + " ";
		}

		return s;

	}

	void DeleteHeap() throws IOException {

		DeleteRoot();
		pArray = null;
		return;
	}

	void DeleteRoot() throws IOException {

		PrintWriter out = new PrintWriter(new FileWriter(outFile, true)); // appending to output file
		
		out.println("Delete Heap :");

		while (!isHeapEmpty()) {
			int lowest = pArray[1];
			out.print("Delete " + lowest + '\t');
			pArray[1] = pArray[pArray[0]];
			pArray[0]--;
			bubbleDown();
			out.println(printHeap(10));
		}
		
		out.print('\n' + "Final Heap :" + '\n' + printHeap(size));
		
		out.close(); // output file closed

		return;

	}

	void bubbleDown() {

		int parentIndex = 1;
		int leftChild = parentIndex * 2;
		int rightChild = (parentIndex * 2) + 1;

		while (((leftChild <= pArray[0] && pArray[parentIndex] > pArray[leftChild]))
				|| ((rightChild <= pArray[0]) && pArray[parentIndex] > pArray[rightChild])) {

			if ((pArray[leftChild] > pArray[rightChild]) && (rightChild <= pArray[0])) {

				int temp = pArray[rightChild];
				pArray[rightChild] = pArray[parentIndex];
				pArray[parentIndex] = temp;
				parentIndex = rightChild;
			}

			else {

				int temp = pArray[leftChild];
				pArray[leftChild] = pArray[parentIndex];
				pArray[parentIndex] = temp;
				parentIndex = leftChild;
			}

			leftChild = parentIndex * 2;
			rightChild = (parentIndex * 2) + 1;

		}

		return;
	}

}
