
public class LinkedList {

	private Node head;

	public LinkedList(int x){
		head = new Node(x);
	}
	
	public LinkedList(Node n) {
		head = n;
	}
	
	public void append(int x) {
		if(head!=null){
			Node current = head;
			while (current.getNext()!=null){
				current = current.getNext();
			}
			current.setNext(new Node(x));
		}else {
			head =new Node(x);
		}
	}
	
	public void insert(int x){
		if (head.getData()>x){
			head = new Node(x,head); // case 1: insert at beginning
		} else {
			Node current = head;
			Node previous = head;
			boolean inserted = false;
			while (current!=null){
				if(current.getData()<x){
					previous = current;
					current = current.getNext();
				}
				else {
					previous.setNext(new Node(x,current)); // case 2: insert into the middle
					inserted = true;
					break;
				} // if - else (current.getData()<x)
			} // while
			if (!inserted) {
				previous.setNext(new Node(x)); // case 3: insert at end
			}
		} // if-else (head.getData>x)
	}
	
	public Node find(int x) {
		Node current = head;
		while (current!=null){
			if (current.getData()==x){
				break;
			} else {
				current = current.getNext();
			}
		}
		return current;
	}
	
	public boolean delete (int x){
		if (head.getData()==x){
			head = head.getNext();  // case 1: deleting the head
			return true;
		}
		Node current = head;
		Node previous = head;
		while (current!=null){
			if (current.getData()==x){
				previous.setNext(current.getNext()); // case 2: delete middle or end
				return true;
			} else {
				previous = current;
				current = current.getNext();
			}
		}
		return false;
	}
	
	public String toString(){
		String s = " ";
		Node current =head;
		while (current!=null){
			s = s + current.getData() + " ";
			current = current.getNext();
		}
		return s;
	}

	
	
}
