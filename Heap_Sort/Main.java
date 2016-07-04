import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		if(args.length < 2) System.out.println("No file found.");
		else {
			FileReader theFile;
			BufferedReader inFile;
			String oneline;
			
			try {				
				theFile = new FileReader(args[0]);
				inFile = new BufferedReader(theFile);
				
				int count = 0;
				
				while((oneline = inFile.readLine()) != null) {
					
					if(oneline.length() > 0) {
						String line1[] = oneline.split(" ");
						for(int i = 0; i < line1.length; i++) {
							count++;
						}
					}
				}
				
				inFile.close(); // input file closed
						
				HeapSort s = new HeapSort(count+1, args[0], args[1]);
				s.DeleteHeap();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

	}

}
