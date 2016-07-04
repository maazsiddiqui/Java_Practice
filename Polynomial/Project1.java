import java.io.*;

public class Project1 {

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
					
					Polynomial a = new Polynomial(null);
					Polynomial b = new Polynomial(null);
					
					String line1[] = oneline.split(" ");
					for(int i = 0; i < line1.length; i++) {
						a.append(Integer.parseInt(line1[i]));
					}
					
					oneline = inFile.readLine();
					
					String line2[] = oneline.split(" ");
					for(int i = 0; i < line2.length; i++) {
						b.append(Integer.parseInt(line2[i]));
					}
					
					System.out.println("Input: " + a.toString());
					System.out.println("Input: " + b.toString());
					
					System.out.println("--------------");
					
					System.out.println("Sum: " + (Polynomial.sum(a, b)).toString());
					System.out.println("Product: " + (Polynomial.product(a, b)).toString());
					
					oneline = inFile.readLine();	// skipping blank line after every two polynomial inputs
					System.out.println("--------------");
					System.out.println("--------------");
					System.out.println();

				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}