
/**
 * 
 * Create a simple tic-tac-toe game. Create a double array (2 dimensional array) of type char to store
 * the state of the tic-tac-toe board. (Each square has an 'X' and 'O' or is blank). Use JOptionPane to
 * ask the user to pick a square. The input should be a single digit, “1” for the top left corner, “2”
 * for top center square, “3” for top right square, etc. Use a loop to keep asking for the next move
 * until the board is filled or until someone has one. You will have to create a way to check if a
 * player won. Make this a separate method. There is a straighforward and thorough way to check and
 * there is a more efficient way. Try to identify both and encode the more efficient way. If the user
 * inputs a square that has already been picked or if it is an invalid entry, the user should be prompted
 * for a different square. After each move, print out the current state of the board to the console.
 *  
 * 
 * @author Maaz Siddiqui
 *
 */

import javax.swing.JOptionPane;

public class TicTacToe1 {
	
	static int turn = 1;
	
	static char x = 'X';
	
	static char o = 'O';

	public static void main(String[] args) {
	
		char [][] board = new char[3][3];
		
		while (fullcheck(board)) {
			
			input(board);
			
			print(board);
			
		}
		
		
		
	} // end of main
	
	
	public static boolean won(char[][] a, int row, int col) {
		
		if (turn > 4) {
			
			char winner = a[row][col];
			
			//checking column
	    	for(int i = 0; i < 3; i++) {
	    		
	    		if(a[row][i] != winner)
	    			
	    			break;
	    		
	    		if(i == 2){
	    			
	    			print(a);
	    			
	    			JOptionPane.showMessageDialog(null, winner + " Wins");
	    			
	    			System.exit(0);
	    		
	    		}
	    		
	    	}

	    	//checking row
	    	for(int i = 0; i < 3; i++){
	    		
	    		if(a[i][col] != winner)
	    			
	    			break;
	    		
	    		if(i == 2) {
	    			
	    			print(a);

	    			JOptionPane.showMessageDialog(null, winner + " Wins");
	    			
	    			System.exit(0);
	    			
	    		}
	    		
	    	}

	    	//checking diagonal
	    	if(row == col) {
	    		
	    		for(int i = 0; i < 3; i++){
	    			
	    			if(a[i][i] != winner)
	    				
	    				break;
	    			
	    			if(i == 2){
	    				
	    				print(a);
	    				
	    				JOptionPane.showMessageDialog(null, winner + " Wins");
	    				
	    				System.exit(0);
	    				
	    			}
	    			
	    		}
	    		
	    	}

	        //checking other diagonal
	    	for(int i = 0; i < 3; i++) {
	    		
	    		if(a[i][2 - i] != winner)
	    			
	    			break;
	    		
	    		if(i == 2){
	    		
	    			print(a);
	    			
	    			JOptionPane.showMessageDialog(null, winner + " Wins");
	    			
	    			System.exit(0);
	    			
	    		}
	    		
	    	}
	    	
	    	return true;
	    	
		}
		
		else 
			
			return false;
		
	}
	
	
	public static boolean fullcheck(char[][] a) {
		
		for (int r = 0; r < 3; r++) {
			
			for (int c = 0; c < 3; c++) {
	
				if (a[r][c] == '\u0000') { 
					
					return true;
				
				}	
			
			}
			
		}
		
		print(a);
		
		System.out.println("Game Drawn");
		
		return false;
		
	}


	public static void input(char[][] a) {
		
		int selectsq = Integer.parseInt(JOptionPane.showInputDialog(null, "Pick a square number"));
		
		switch (selectsq) {
		
		case 1:
			if (a[0][0] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[0][0] = x;
					
					turn++;
					
				}
				
				else {
					
					a[0][0] = o;
					
					turn++;
										
				}
			
				won(a, 0, 0);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}
		
		case 2:
			if (a[0][1] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[0][1] = x;
					
					turn++;
					
				}
				
				else {
					
					a[0][1] = o;
					
					turn++;
					
				}
			
				won(a, 0, 1);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}
		
		case 3:
			if (a[0][2] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[0][2] = x;
					
					turn++;
					
				}
				
				else {
					
					a[0][2] = o;
					
					turn++;
										
				}
			
				won(a, 0, 2);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}	
			
		case 4:
			if (a[1][0] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[1][0] = x;
					
					turn++;
					
				}
				
				else {
					
					a[1][0] = o;
					
					turn++;
										
				}
			
				won(a, 1, 0);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}
			
		case 5:
			if (a[1][1] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[1][1] = x;
					
					turn++;
					
				}
				
				else {
					
					a[1][1] = o;
					
					turn++;
										
				}
			
				won(a, 1, 1);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}
			
		case 6:
			if (a[1][2] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[1][2] = x;
					
					turn++;
					
				}
				
				else {
					
					a[1][2] = o;
					
					turn++;
										
				}
			
				won(a, 1, 2);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}	
			
		case 7:
			if (a[2][0] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[2][0] = x;
					
					turn++;
					
				}
				
				else {
					
					a[2][0] = o;
					
					turn++;
										
				}
			
				won(a, 2, 0);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}	
		
		case 8:
			if (a[2][1] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[2][1] = x;
					
					turn++;
					
				}
				
				else {
					
					a[2][1] = o;
					
					turn++;
										
				}
			
				won(a, 2, 1);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}	
		
		case 9:
			if (a[2][2] == '\u0000') {
				
				if (turn % 2 != 0) {
					
					a[2][2] = x;
					
					turn++;
					
				}
				
				else {
					
					a[2][2] = o;
					
					turn++;
										
				}
			
				won(a, 2, 2);
				
				break;
				
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Pick another number");
				
				input(a);
				
				break;
				
			}	
			
		default:			
			JOptionPane.showMessageDialog(null, "Number must be 1 to 9");
			
			input(a);
			
			break;
		
		} // end of switch loop
		
	}


	/**
	 * method to print 2D char array
	 * 
	 * @param a
	 */
	
	public static void print(char[][] a) {
	
		for (int r = 0; r < 3; r++) {
		
			for (int c = 0; c < 3; c++) {
	
				System.out.print(a[r][c]);
				
				System.out.print(" ");
			
			}
		
			System.out.println();
		
		}

		System.out.println("-----");
		
	} // end of print method
	
} // end of program
