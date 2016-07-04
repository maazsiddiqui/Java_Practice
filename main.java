
public class main {

	public static void main(String[] args) {
		
		int[] arr = {20, 6, 2, 8, 7, 1000, 57, 12};
		
		printArray(arr);
		System.out.println();
		selectionSort(arr);
		printArray(arr);
	}
	
	static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int smallestIndex = minIndex(arr, i);
			if (smallestIndex != i) swap(arr, smallestIndex, i);
		}
	}
	
	static int minIndex(int[] arr, int low) {
		int min = low;
		for (int i = min+1; i < arr.length; i++) {
			if(arr[i] < arr[min]) min = i;
		}
		return min;
	}
	
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;		
	}
	
	static void printArray(int[] arr) {
		for (int element: arr) {
			System.out.print(element + " ");
		}
	}

}