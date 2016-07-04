
public class LinkedList2 {

	private Node2 head;
	private Node2 last;
	
	public LinkedList2 (int x) {
		head = new Node2(x);
		last = head;
	}
	
	public LinkedList2 (Node2 n) {
		head = n;
		last = head;
	}
	// replace function
	public void replace(int x, int y) {
		Node2 current = find(x);
		if (current == null) return;
		if (current.getPrevious() != null) {
			current.getPrevious().setNext(new Node2(y, current.getNext(), current.getPrevious()));
		}
		else {
			head = new Node2(y, head);
		}
		if (current.getNext() != null) {
			current.getNext().setPrevious(current.getPrevious().getNext());
		}
		else {
			last = current.getPrevious().getNext();
		}
	} // end of replace
	
	public Node2 find(int x) {
		Node2 current = head;
		while (current!=null){
			if (current.getData()==x){
				break;
			} else {
				current = current.getNext();
			}
		}
		return current;
	}
	
	public void insert(int x) {
		if (head.getData()>x){
			head = new Node2(x, head); // case 1: insert before the head
			head.getNext().setPrevious(head);
		} else {
			Node2 current = head;
			while (current != null){
				if (current.getData()<x) {
					current = current.getNext();
				}else {
					// case 2: insert into the middle of the list
					current.getPrevious().setNext(new Node2(x, current, current.getPrevious()));
					current.setPrevious(current.getPrevious().getNext());
					break;
				}
				if (current == null){
					last.setNext(new Node2(x, null, last)); // case 3: insert at end
					last = last.getNext();
				}
			}
		
		}
	}
		
	public boolean delete (int x) {
		Node2 current = find(x);
		if (current == null){
			return false;
		}
		if (current.getPrevious() !=null){
			current.getPrevious().setNext(current.getNext());
		} else {
			head = current.getNext();
		}
		if (current.getNext()!=null){
			current.getNext().setPrevious(current.getPrevious());
		} else {
			last = current.getPrevious();
		}
		return true;
		
	}
		
		
		
		
		
		
		
		
		
}
	
