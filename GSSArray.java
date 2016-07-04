
public class GSSArray {

	private int [] arr;
	
	private int lastIndex;

	public GSSArray(int x) {
		
		arr = new int[x];
		
		lastIndex = 0;
	
	}

	// print function
	
	public void printArray() {
		
		for(int i = 0 ; i <= lastIndex - 1; i++) {
			
			System.out.print(arr[i] + " ");
		
		}
		
		System.out.println("\nLast Index: " + lastIndex);
	
	} // end of print function
	
	// insert function
	
	public void insert(int x) {
		
		// if array is empty
		
		if (lastIndex == 0) {
			
			arr[0] = x;
			
			lastIndex++;
			
			return;
			
		} // end of if loop
		
		// checking and expanding array
		
		if (lastIndex == arr.length - 1) {
			
			arr = increaseSize(arr);
			
		} // end of if loop
		
		for (int i = lastIndex; i > 0; i--) {
			
			// insertion in beginning of array
			
			if (x < arr[0]) {
				
				for (int j = lastIndex; j > 0; j--) {
					
					arr[j] = arr[j-1];
					
				}
				
				arr[0] = x;
				
				lastIndex++;
				
				return;
			
			}
			
			// insertion in between or end of array
			
			if (x >= arr[i-1]) {
			
				for (int j = lastIndex; j > i - 1; j--) {
					
					arr[j] = arr[j-1];
					
				}
				
				arr[i] = x;
				
				lastIndex++;
				
				return;
				
			}
			
		}
		
	} // end of insert function
	
	// function to make array size double
	
	private int[] increaseSize(int [] a) {
		
		int [] temp = new int[a.length * 2];
		
		for(int i = 0 ; i < a.length; i++) {
			
			temp[i] = a[i];
		
		}
		
		return temp;

	} // end of function

	// delete function
	
	public boolean delete(int x) {
		
		if(lastIndex == 0) {
			
			return false;
		
		}

		for(int i = 0; i < lastIndex; i++) {
			
			if(arr[i] == x) {
				
				for (int j = i; j <= lastIndex; j++)
				
				arr[j] = arr[j+1];
			
			}

		}
		
		lastIndex--;
		
		return true;
	
	} // end of delete function

} // end of class
