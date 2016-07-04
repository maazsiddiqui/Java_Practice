// Assignment 2

public class Array_IntString {

	public static void main(String[] args) {
		
		int [] intarray = new int[50];
		
		String [] stringarray = new String[50];
		
		// Generating random integers between 0 to 1000
		
		for (int i = 0; i < intarray.length; i++) {
			
			intarray[i] = (int) (Math.random() * 1000);
			
		} // end of for loop
		
		// Converting int array to string
		
		for (int i = 0; i < stringarray.length; i++) {
			
			stringarray[i] = Integer.toString(intarray[i]);
			
		} // end of for loop
		
		System.out.println("Unsorted arrays");
		
		// Printing unsorted int array
		
		for (int i = 0; i < intarray.length; i++) {
			
			System.out.print(intarray[i] + " ");
						
		} // end of for loop
		
		System.out.println();
		
		// Printing unsorted string array
		
		for (int i = 0; i < stringarray.length; i++) {
			
			System.out.print(stringarray[i] + " ");
						
		} // end of for loop
		
		System.out.println();
		
		// bubble sort on int array
		
		boolean flag = false;
		
		while (!flag) {
			
			flag = true;
		
			for (int i = 0; i < intarray.length - 1; i++) {
			
				if (intarray[i] > intarray[i+1]) {
				
					int temp = intarray[i];
				
					intarray[i] = intarray[i+1];
				
					intarray[i+1] = temp;
					
					flag = false;
					
				} // end of if loop
			
			} // end of for loop
			
		} // end of while loops
		
		System.out.println("Sorted arrays");
		
		// Printing sorted int array
		
		for (int i = 0; i < intarray.length; i++) {
			
			System.out.print(intarray[i] + " ");
						
		}
		
		System.out.println();
		
		// Method call to sort string array
		
		selection(stringarray);
		
		// Printing sorted int array
		
		for (int i = 0; i < stringarray.length; i++) {
			
			System.out.print(stringarray[i] + " ");
			
		}
		
	}
	
	// Selection sort for string array

	public static void selection(String[] a) {
		
		for (int i = 0; i < a.length - 1; i++) {
			
			int index = findMin(a, i);
			
			String temp = a[index];
			
			a[index] = a[i];
			
			a[i] = temp;
		}
		
	}
	
	public static int findMin(String[] a, int x) {
		
		int index = x;
		
		String min = a[x];
		
		for (int i = x + 1; i < a.length; i++) {
			
			if (min.compareTo(a[i]) > 0) {
				
				index = i;
				
				min = a[i];
				
			}
			
		}	
		
		return index;
		
	}
	
} // end of program