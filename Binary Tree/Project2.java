import java.io.*;

public class Project2 {

	public static void main(String[] args) {

		if(args.length == 0) System.out.println("No file found.");
		else {
			FileReader theFile;
			BufferedReader inFile;
			String oneline;
			
			try {				
				theFile = new FileReader(args[0]);
				inFile = new BufferedReader(theFile);
				
				while((oneline = inFile.readLine()) != null) {
					
					BinaryTree a = new BinaryTree();
					
					int h;
					
					String[][] n = new String[9][71];
					
					fillArray(n);

					String line[] = oneline.split(" ");
					for(int i = 0; i < line.length; i++) {
						a = BinaryTree.insert(a, Integer.parseInt(line[i]));
					}
					
					h = a.height();
					
					n = BinaryTree.bstToArray(n, a, h, 30, 0);

					printArray(n);
					
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					
					oneline = inFile.readLine();	// skipping blank line after every two polynomial inputs
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}

	}

	public static void fillArray(String[][] a){
		for (int c = 0; c < a.length; c++) {
			for(int r = 0; r < a[c].length; r++) {
				a[c][r] = " ";
			}
		}
	}
	
	public static void printArray(String[][] a){
		for (int c = 0; c < a.length; c++) {
			for(int r = 0; r < a[c].length; r++) {
				System.out.print(a[c][r]);
			}
			System.out.println();
		}
	}

}
