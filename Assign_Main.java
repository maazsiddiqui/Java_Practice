
public class Assign_Main {

	public static void main(String[] args) {
		
		GSSArray temp = new GSSArray(5);
		
		temp.insert(17);
		temp.insert(12);
		temp.insert(8);
		temp.insert(2);
		temp.insert(11);
		temp.insert(4);
		temp.insert(52);
		temp.insert(21);
		
		temp.delete(11);
		
		temp.printArray();
		
		

	}

}
