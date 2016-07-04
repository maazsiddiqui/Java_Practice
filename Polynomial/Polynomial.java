public class Polynomial {

	private Node head;
	private int size;

	public Polynomial() {
		head = null;
		setSize(0);
	}
	
	public Polynomial(int x){
		head = new Node(x, null);
	}
	
	public Polynomial(Node n) {
		head = n;
	}
	
	public void append(int x) {
		
		if(head != null) {
			Node current = head;
			while (current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(new Node(x, null));
			setSize(getSize() + 1);
		}
		else {
			head = new Node(x, null);
			setSize(getSize() + 1);
		}
	}
	
	public void insert(int x){

		if(head != null) {
			head = new Node(x, head);
			setSize(getSize() + 1);
		}
		else {
			head = new Node(x, null);
			setSize(getSize() + 1);
		}
	}
	
	public String toString(){
		String s = "";
		Node current = head;
		while (current!=null){
			s = s + current.getElement() + " ";
			current = current.getNext();
		}
		return s;
	}

	public static Polynomial sum(Polynomial a, Polynomial b) {
		
		Polynomial add = new Polynomial(null);
		Polynomial smaller = new Polynomial(null);
		
		if(a.getSize() >= b.getSize()) {
			
			Node current = a.head;
			
			while (current.getNext() != null) {
				add.append(current.getElement());
				current = current.getNext();
				
				if((current.getNext() == null)) {
					add.append(current.getElement());
				}
			}
			
			smaller = b;
		}
		
		else {
			
			Node current = b.head;
			
			while (current.getNext() != null) {
				add.append(current.getElement());
				current = current.getNext();
				
				if((current.getNext() == null)) {
					add.append(current.getElement());
				}
			}

			smaller = a;
		}	
		
		Node current_add = add.head;
		Node current_smaller = smaller.head;
		
		while (current_smaller.getNext() != null) {
			
			current_add.setElement(current_add.getElement() + current_smaller.getElement());
			
			current_add = current_add.getNext();
			current_smaller = current_smaller.getNext();
			
			if((current_smaller.getNext() == null)) {
				current_add.setElement(current_add.getElement() + current_smaller.getElement());
			}
		}
		
		return add;
	}
	
	public static Polynomial product(Polynomial a, Polynomial b) {

		Polynomial mul1 = new Polynomial(null);
		Polynomial mul2 = new Polynomial(null);
		Polynomial add1 = new Polynomial(null);
		Polynomial add2 = new Polynomial(null);
		Polynomial ans = new Polynomial(null);
		int num = 1;
		
		if(a.getSize() >= b.getSize()) {
			Node current = a.head;
			while (current.getNext() != null) {
				mul1.append(current.getElement());
				current = current.getNext();
				if((current.getNext() == null)) {
					mul1.append(current.getElement());
				}
			}
			mul2 = b;
		}
		else {
			Node current = b.head;
			while (current.getNext() != null) {
				mul1.append(current.getElement());
				current = current.getNext();
				if((current.getNext() == null)) {
					mul1.append(current.getElement());
				}
			}
			mul2 = a;
		}
		mul1.reverse();
		mul2.reverse();	
		Node current_mul2 = mul2.head;
		Node current_mul1 = mul1.head;		
		while(current_mul1.getNext() != null) {
			ans.append(current_mul1.getElement() * current_mul2.getElement());
			current_mul1 = current_mul1.getNext();
			if(current_mul1.getNext() == null) {
				ans.append(current_mul1.getElement() * current_mul2.getElement());
			}
		}
			
		while(current_mul2.getNext() != null) {
			current_mul2 = current_mul2.getNext();
			current_mul1 = mul1.head;
			while(current_mul1.getNext() != null) {
				add2.append(current_mul1.getElement() * current_mul2.getElement());
				current_mul1 = current_mul1.getNext();
				if(current_mul1.getNext() == null) {
					add2.append(current_mul1.getElement() * current_mul2.getElement());
				}
			}
			for(int i = 0; i < num; i++){
				add2.insert(0);	
			}
			num++;
			add1 = ans;
			ans = sum(add1, add2);
			add2.head = null;
		}
		ans.reverse();
		return ans;
		
	}
	
	public void reverse() {
		
		Node p, q;
		if(head != null) {
			p = head.getNext();
			head.setNext(null);
			while(p != null) {
				q = p.getNext();
				p.setNext(head);
				head = p;
				p = q;
			}
		}
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
