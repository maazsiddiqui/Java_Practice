public class node {

	private int data;
	private node next;
		
	node() {
		data = -9999;
		next = null;
	}

	node(int a) {
		data = a;
		next = null;
	}

	int getData() {
		return data;
	}

	node getNext() {
		return next;
	}

	void setNext(node n) {
		next = n;
	}	
}
