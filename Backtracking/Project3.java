import java.io.*;

public class Project3 {

	static int[][] temp = new int[10][10];
	static boolean found = false;
	static int nr = 0;
	static int nc = 0;
	
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
					
					int[][] maze = new int[10][10];
					
					for(int i = 0; i < 10; i++) {
						String line1[] = oneline.split(" ");						
						for (int c = 0; c < 10; c++) {
							maze[i][c] = (Integer.parseInt(line1[c]));
						}
						oneline = inFile.readLine();
					}
					
					System.out.println("Problem");
					System.out.println("===================");
					
					printArray(maze);
										
					System.out.println();
					
					findWay(maze, 0, 0, 9, 9);
					
					if (found == true) {
						
						System.out.println();
						
						System.out.println("Solution");
						System.out.println("===================");
						
						printArray(maze);
						System.out.println();
					}
					else {
						System.out.println("No Solution Found");
						System.out.println();
					}
					
					fillArray(temp);
					found = false;
					nr = 0;
					nc = 0;
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void printArray(int[][] a){
		for (int c = 0; c < 10; c++) {
			for(int r = 0; r < 10; r++) {
				System.out.print(a[c][r]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	static void findWay(int[][] m, int sr, int sc, int dr, int dc) {
		
		if (sr == dr && sc == dc) found = true;
		else {
			temp[sr][sc] = 1;
			while (!found && possibleToMove(m, sr, sc)) findWay(m, nr, nc, dr, dc);			
		}	
		if (found) m[sr][sc] = 2;
	}
	
	static boolean possibleToMove(int[][] m, int sr, int sc) {
		
		if (sc < 9 && m[sr][sc+1] == 0 && temp[sr][sc+1] != 1) { //checking right
			nr = sr;
			nc = sc+1;
			return true;		
		}
		
		if (sr < 9 && m[sr+ 1][sc] == 0 && temp[sr+1][sc] != 1) { //checking down
			nr = sr+1;
			nc = sc;
			return true;		
		}
		
		if (sc >= 1 && m[sr][sc-1] == 0 && temp[sr][sc-1] != 1) { //checking left
			nr = sr;
			nc = sc-1;
			return true;		
		}
	
		if (sr >= 1 && m[sr-1][sc] == 0 && temp[sr-1][sc] != 1) { //checking up
			nr = sr-1;
			nc = sc;
			return true;		
		}
		
		System.out.print("Start backtracking from [");
		System.out.print(sr);
		System.out.print(", ");
		System.out.print(sc);
		System.out.print("]");
		System.out.println();
			
		return false;
	}

	static void fillArray(int[][] a){
		for (int c = 0; c < 10; c++) {
			for(int r = 0; r < 10; r++) {
				a[c][r] = 0;
			}
		}
	}

}