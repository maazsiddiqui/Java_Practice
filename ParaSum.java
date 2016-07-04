/**
 * 1a) Create a recursive static method called summation that will take
 * in 2 parameters of type int and return the sum of all of the numbers
 * from the 1st number to the 2nd number (including the 1st and last number).
 * Assume the 1st parameter is less than or equal to the 2nd parameter.
 * 
 * 1b) Create another method called summation2, which does the same thing
 * as summation except that the 1st parameter could be less than the 2nd.
 * 
 * 2a) Create a recursive method in class Node. Call it partialSum. The
 * method should return the sum of the data value of Node the method was 
 * called on and the sum of the data values of all of the Nodes after it 
 * in the LinkedList. For example, if the values in the nodes in the 
 * list are 1 through 13, and method partial sum is called on the 7th node, 
 * the method should return 70.
 * 
 * b) Create a method in class LinkedList called printBack() on its head
 * variable. Create method printBack in class Node. This method should 
 * output to the console in reverse order the data values in each node 
 * from the last node in the list until the current node. So, for the 
 * example in part 2a, the output should look like: 13 12 11 10 9 8 7
 * 
 * @author Maaz Siddiqui
 *
 */


public class ParaSum {

	public static void main(String[] args) {
		
		// Question 1A Testing
		System.out.println("Answer question(1a): " + sumUp(1, 100));
		
		// Question 1B Testing
		System.out.println("Answer question(1b): " + sumUp2(100, 1));
		
		LinkedList link = new LinkedList(1);
		
		for (int i = 2; i < 14; i++) {
			
			link.append(i);
					
		}
		
		System.out.println("Testing LinkedList" + '\n' + link.toString());
		
		System.out.print("LinkedList Sum: ");
		
		System.out.println(link.partialSum(link.find(7)));
		
		System.out.print("Reverse Print: ");
		
		link.printBack(link.find(7));
		
	}

	public static int sumUp(int a, int b) {
		
		if (a == b) {
			
			return a;
		
		}
		
			return b + sumUp(a, --b);

	}
	
	public static int sumUp2(int a, int b) {
		
		if (a == b) {
			
			return a;
		
		}
		
		if (a > b)
		
			return a + sumUp2(--a, b);
		
		else
			
			return b + sumUp2(a, --b);
		
	}
	
}