import java.io.*;

public class Node {
	
	private String data;
	private Node next;
	
	Node() {
		data = "-9999";
		next= null;
	}

	Node(String a) {
		data = a;
		next = null;
	}

	String getData() {
		return data;
	}

	Node getNext() {
		return next;
	}

	void setNext(Node n) {
		next = n;
	}

}
