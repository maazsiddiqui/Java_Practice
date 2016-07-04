import java.io.*;
import java.util.*;

public class Yodle {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//	input file as LinkedList
		Scanner dataFile = new Scanner(new File(args[0]));
		LinkedList<Integer> listInt = new LinkedList<Integer>();
		while (dataFile.hasNextInt()) listInt.add(dataFile.nextInt());
		dataFile.close(); // input file closed
		
		//	calculate number of lines	
		int totalSize = listInt.size();
		int totalLines = 0;
		while (totalSize != 0) totalSize -= ++totalLines;

		while (listInt.size() != 1) {
			for(int i = (totalLines - 1); i > 0; i--) {
				int lastItem = listInt.removeLast();
				int parentIdx = listInt.size() - (totalLines - 1) - 1;
				listInt.set(parentIdx, listInt.get(parentIdx) + (Math.max(listInt.peekLast(), lastItem)));
			}
			totalLines--;
			listInt.removeLast();
		}
		System.out.println("Answer: " + listInt.remove());
	}
}