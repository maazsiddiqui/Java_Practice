import java.io.*;

public class main {

	public static void main(String[] args){
		
		if (args.length != 2) {
			System.out.println("Improper command line arguments.");
			return;
		}
		
		bucketSort sortMyFile = new bucketSort(args[0], args[1]);	

	}
}