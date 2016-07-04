
public class Stack extends LinkedList {

	public Stack(int x){
		
		head = new Node(x);
		
		last = head;
	
		count++;
		
	}

	public void insert(int x) {
				
		head.setNext(new Node(x));
			
		head = head.getNext();
			
		count++;
			
	}
		
	public boolean delete(int x) {
	
		while (x > 0) {
		
			if (last != null) {
				
				head = last;
				
				for (int i = 0; i < count - 2; i++) {
					
					head = head.getNext();				
					
				}
					
				count--;
				
			} // end of if
			
			if (count <= 0) {
				
				System.out.println("Nothing found in stack, Goodbye");
				
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
