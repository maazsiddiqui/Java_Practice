import java.io.*;

public class dijktraSSS {
	
	private int N;
	private int sourceNode;
	private int minNode;
	private int currentNode;
	private int newCost;
	private int[][] costMatrix; // dynamic array
	private int[] fatherArray; // dynamic array
	private int[] markedArray; // dynamic array
	private int[] bestCostArray; // dynamic array
	
	// CONSTRUCTOR
	
	dijktraSSS(int n) {
		
		N = n;
		
		costMatrix = new int[N][];
		for(int i = 0; i < costMatrix.length; i++) {
			costMatrix[i] = new int[N];
		}
		
		make2DArrayZero(costMatrix);
		
		fatherArray = new int[N];
		markedArray = new int[N];
		bestCostArray = new int[N];		
	}
	
	public int computeCost(int min, int current) {
		return bestCostArray[minNode] + costMatrix[min][current];
	}
	
	public int findUnmarkedMinNode() {

		int index = 999999;
		int cost = 999999;
		
		for(int j = 0; j < bestCostArray.length; j++) {
			if(cost > bestCostArray[j] && markedArray[j] == 0) {
				cost = bestCostArray[j];
				index = j;
			}	
		}
		return index;
	}
	
	public void resetAll() {
		
		minNode = 0;
		currentNode = 0;
		newCost = 0;
		
		for(int i = 0; i < fatherArray.length; i++) {
			fatherArray[i] = i+1;
		}
		
		make1DArrayZero(markedArray);
		
		for(int i = 0; i < bestCostArray.length; i++) {
			bestCostArray[i] = 9999;
		}
	}
	
	public void makeZeroUnlimited() {
		for(int i = 0; i < costMatrix.length; i++) {
			for(int j = 0; j < costMatrix[i].length; j++) {
				if(costMatrix[i][j] == 0) costMatrix[i][j] = 99999;
			}
		}
	}
	
	public void printMarkedArray(String min) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(min, true));
		out.println();
		out.println("MarkedArray: ");
		for(int i = 0; i < markedArray.length; i++) {
			out.print(markedArray[i] + " ");
		}
		out.println();
		out.close(); // output file closed
	}
	
	public void printMinNode(String min) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(min, true));
		out.println();
		out.println("MinNode: " + (minNode+1));
		out.close(); // output file closed
	}
	
	public void printFatherArray(String min) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(min, true));
		out.print("Father Array: ");
		for(int i = 0; i < fatherArray.length; i++) {
			out.print(fatherArray[i] + " ");
		}
		out.println();
		out.close(); // output file closed
	}
	
	public void printBestCostArray(String min) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(min, true));
		out.print("Best Cost Array: ");
		for(int i = 0; i < bestCostArray.length; i++) {
			out.print(bestCostArray[i] + " ");
		}
		out.println();
		out.println();
		out.close(); // output file closed
	}
	
	public void startDijktraSSS(int s, String out1, String out2) throws IOException {
		
		resetAll();
			
		sourceNode = s-1;
		bestCostArray[sourceNode] = 0;
		
		makeZeroUnlimited();
		
		while(!allNodesMarked()) {
					
			minNode = findUnmarkedMinNode();
			updateMarkedArray(minNode);
			
			if(sourceNode == 0) {
				printMarkedArray(out2);
				printMinNode(out2);
			}
				
			for(int i = 0; i < markedArray.length; i++) {
				
				if(markedArray[i] == 0) {
					currentNode = i;
				}
				
				int newCost = computeCost(minNode, currentNode);
				
				if(newCost < bestCostArray[currentNode]) {
					updateFatherArray(currentNode, minNode);
					updateBestCost(currentNode, newCost);
					if(sourceNode == 0) {
						printFatherArray(out2);
						printBestCostArray(out2);
					}
				}	
			}
		}
		
		PrintWriter out = new PrintWriter(new FileWriter(out1, true));
		out.println("The graph has " + N + " nodes, the source node is " + (sourceNode + 1));
		out.close(); // output file closed
		
		for(int i = 0; i < N; i++) {
			findNprintShortestPath(i, out1);
		}
		
		PrintWriter outfile = new PrintWriter(new FileWriter(out1, true));
		outfile.println();
		outfile.close(); // output file closed
		
	}
	
	public void findNprintShortestPath(int i, String outFile) throws IOException {
		
		LLStack myStack = new LLStack();
		myStack.push(i+1);
		int temp = fatherArray[i]-1;
		
		while(temp != sourceNode && temp != i) {
			myStack.push(temp+1);
			temp = fatherArray[temp]-1;
		}
		
		myStack.push(sourceNode + 1);
		
		PrintWriter out = new PrintWriter(new FileWriter(outFile, true));

		out.print("The path from " + (sourceNode + 1) + " to " + (i+1) + ": ");
		out.close(); // output file closed

		myStack.printToFile(outFile);
		
		PrintWriter out2 = new PrintWriter(new FileWriter(outFile, true));
		
		out2.println(" cost = " + (bestCostArray[i]));
		
		out2.close(); // output file closed

		return;
	}
	
	public boolean allNodesMarked() {
		for(int i = 0; i < markedArray.length; i++) {
			if(markedArray[i] == 0) return false;
		}
		return true;
	}
	
	public void updateFatherArray(int current, int min) {
		fatherArray[current] = min+1;
	}
	
	public void updateBestCost(int current, int newCost) {
		bestCostArray[current] = newCost;
	}
	
	public void printAll() {
		
		System.out.print("Best Cost Array: ");
		print1DArray(bestCostArray);
		System.out.println();
		
		System.out.print("Father Array: ");
		print1DArray(fatherArray);
		System.out.println();
		
		System.out.print("Marked Array: ");
		print1DArray(markedArray);
		System.out.println();
		
		System.out.println("Min Node: " + minNode);
		System.out.println();
		
		System.out.println("Current Node: " + currentNode);
		System.out.println();

	}
	
	public void updateMarkedArray(int n) {
		markedArray[n] = 1;
	}
	
	// Function call to make 2D array zero
	
	public void make2DArrayZero(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = 0;
			}			
		}
	}
	
	// function call to print 2D array
	
	public void printCostMatrix(String outFile) throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter(outFile));
		
		out.println("COST MATRIX \n");
		
		for(int i = 0; i < costMatrix.length; i++) {
			for(int j = 0; j < costMatrix[i].length; j++) {
				out.print(costMatrix[i][j] + "\t");
			}			
			out.println();
		}
		
		out.close(); // output file closed
		return;
	}
	
	// function call to mark 1D array zero
	
	public void make1DArrayZero(int[] a) {
		for(int i = 0; i < a.length; i++) {
			a[i] = 0;			
		}
	}
	
	// function call to print 1D array
	
	public void print1DArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");			
		}
		System.out.println();
	}
	
	
	// GETTERS & SETTERS
	
	public int getN() {
		return N;
	}
	
	public void setN(int n) {
		N = n;
	}
	
	public int getSourceNode() {
		return sourceNode;
	}
	
	public void setSourceNode(int sourceNode) {
		this.sourceNode = sourceNode;
	}
	
	public int getMinNode() {
		return minNode;
	}
	
	public void setMinNode(int minNode) {
		this.minNode = minNode;
	}
	
	public int getCurrentNode() {
		return currentNode;
	}
	
	public void setCurrentNode(int currentNode) {
		this.currentNode = currentNode;
	}
	
	public int getNewCost() {
		return newCost;
	}
	
	public void setNewCost(int newCost) {
		this.newCost = newCost;
	}
	
	public int getCostMatrix(int a, int b) {
		return costMatrix[a][b];
	}
	
	public void setCostMatrix(int r, int c, int value) {
		this.costMatrix[r][c] = value;
	}
	
	public int getFatherArray(int a) {
		return fatherArray[a];
	}
	
	public void setFatherArray(int index, int value) {
		this.fatherArray[index] = value;
	}
	
	public int getMarkedArray(int index) {
		return markedArray[index];
	}
	
	public void setMarkedArray(int index, int value) {
		this.markedArray[index] = value;
	}
	
	public int getBestCostArray(int index) {
		return bestCostArray[index];
	}
	
	public void setBestCostArray(int index, int value) {
		this.bestCostArray[index] = value;
	}
	
}
