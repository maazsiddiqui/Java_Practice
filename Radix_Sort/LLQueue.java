import java.io.*;

public class LLQueue {
	
	private Node head;
	private Node tail;
	private String outFile; // pointer to argv[1]
	
	LLQueue() { // default constructor
		head = new Node();
		tail = head;
	}

	void addTail(String a) { // push new node on top of queue

		Node n = new Node(a);
		
		n.setNext(tail.getNext());
		tail.setNext(n);
		tail = tail.getNext();
		
		return;
	}

	String deleteHead() {
		
		if (isEmpty()) return "Empty Queue";
		
		Node current = head.getNext();
		if (current == tail) tail = head;
		head.setNext(current.getNext());
		String temp = current.getData(); // head point to dummy so skipping head
		
		return temp;
	}

	boolean isEmpty() {
		return (head == tail);
	}

	void printQueue() { // special format output function as required
		
		Node current = head.getNext();
		while (current != null) {
			System.out.print(current.getData() + " ");
			current = current.getNext();
		}
		return;	
	}

	void printFileQueue(String outputFile) throws IOException {
		
		outFile = outputFile;
		PrintWriter out = new PrintWriter(new FileWriter(outFile, true)); // opening output file
		Node current = head.getNext();

		while (current != null) {
			out.print(" --> (" + current.getData() + ")");
			current = current.getNext();
		}
		
		out.close(); // close output file
		return;
	}
}
