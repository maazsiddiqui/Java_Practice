import java.io.*;

public class LLStack {
	
	private node Top;
		
	LLStack() { // default constructor
		Top = null;
	}

	node getTop() {
		return Top;
	}

	void push(int a) { // push new node on top of stack

		node n = new node(a);
			
		if (Top == null) Top = n;
		else {
			n.setNext(Top);
			Top = n;
		}
		return;
	}

	int pop() {
		int temp = -1;
		node n = Top;
			
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

		node current = Top;
			
		while (current != null) {
			System.out.print(" -> " + current.getData());
			current = current.getNext();
		}	

		return;
	}

	void printToFile(String outputFile) throws IOException {
			
		PrintWriter out = new PrintWriter(new FileWriter(outputFile, true)); // opening output file
	
		node current = Top;
			
		while (current != null) {
			out.print(current.getData());
			current = current.getNext();
			if(current != null) out.print(" --> ");
		}

		out.close(); // close output file

		return;
	}

}

