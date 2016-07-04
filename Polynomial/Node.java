public class Node {

	private int element;
	private Node next;

	Node() {
		this(0, null);
	}

	public Node(int d, Node n) {
		element = d;
		next = n;
	}

	void setElement(int newElem) {
		element = newElem;
	}

	public void setNext(Node n) {
		next = n;
	}

	public int getElement() {
		return element;
	}

	public Node getNext() {
		return next;
	}

}