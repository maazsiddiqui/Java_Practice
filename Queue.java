
public class Queue extends LinkedList {
	
	public Queue(int x) {
		
		head = new Node(x);
		
		count++;
	
	}
	
	public void insert(int x) {
		
		Node current = head;
		
		while (current.getNext() != null) {
		
			current = current.getNext();
		
		}	
		
		current.setNext(new Node(x));
			
		count++;
		
	}

	public boolean delete(int x) {
		
		while (x > 0) {
		
			if (head != null) {
				
				head = head.getNext();
				
				count--;
				
			} // end of if
			
			if (count <= 0) {
				
				System.out.println("Nothing found in Queue, Goodbye");
				
				return false;
				
			} // end of else
			
			x--;
	
		} // end of while loop
		
		return true;
		
	} // end of delete method
	
	public void clearAll() {
		
		while (count > 0) {
			
			System.out.println(head.getData());
			
			System.out.println("---------------");
			
			delete(1);
			
		}
		
	}
	
}
