import java.io.*;

public class LLStack {
	
	private Node Top;
	private String outFile; // pointer to args[1]
	
	LLStack() { // default constructor
		Top = null;
	}

	Node getTop() {
		return Top;
	}

	void push(String a) { // push new node on top of stack

		Node n = new Node(a);
		
		if (Top == null) Top = n;
		else {
			n.setNext(Top);
			Top = n;
		}
		return;
	}

	String pop() {
		String temp = "";
		Node n = Top;
		
		if (isEmpty() != true) {
			temp = Top.getData();
			Top = Top.getNext();
		}
		return temp;
	}

	boolean isEmpty() {
		return (Top == null);
	}

	void printStack() { // special format output function as required

		Node current = Top;
		
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}	

		return;
	}

	void printToFile(String outputFile) throws IOException {
		
		outFile = outputFile;
		
		PrintWriter out = new PrintWriter(new FileWriter(outFile, true)); // opening output file
		
		out.print("Stack");
		
		Node current = Top;
		
		while (current != null) {
			out.print(" --> (" + current.getData() + ")");
			current = current.getNext();
		}
		
		out.println();
		
		out.close(); // close output file

		return;
	}

}
