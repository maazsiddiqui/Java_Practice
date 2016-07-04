import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TTTGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel0, panel1, panel2, panel3;
	private JTextField textField;
	private JButton buttonYes, buttonNo, button1, button2, button3, button4, button5,
					button6, button7, button8, button9;
	
	static int turn = 1;
	static String x = "X";
	static String o = "O";

	public TTTGUI() {
		
		super("Tic Tac Toe");
		
		setSize(350, 350);
		setLocation(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel0 = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		textField = new JTextField("Would you like to play Tic Tac Toe?");
		
		panel1.add(textField);
		panel0.add(panel1);
		
		buttonYes = new JButton("Yes");
		buttonNo = new JButton("No");
		
		panel2.add(buttonYes);
		panel2.add(buttonNo);
		panel0.add(panel2);
		
		add(panel0, BorderLayout.NORTH);		
		
		panel3.setLayout(new GridLayout(3, 3));
		
		button1 = new JButton("");
		button2 = new JButton("");
		button3 = new JButton("");
		button4 = new JButton("");
		button5 = new JButton("");
		button6 = new JButton("");
		button7 = new JButton("");
		button8 = new JButton("");
		button9 = new JButton("");

		panel3.add(button1);
		panel3.add(button2);
		panel3.add(button3);
		panel3.add(button4);
		panel3.add(button5);
		panel3.add(button6);
		panel3.add(button7);
		panel3.add(button8);
		panel3.add(button9);

		add(panel3, BorderLayout.CENTER);

		buttonYes.addActionListener(this);
		buttonNo.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() == buttonYes) {
			
			panel2.setVisible(false);
			
			button1.setEnabled(true);
			button1.setText("");
			
			button2.setEnabled(true);
			button2.setText("");
			
			button3.setEnabled(true);
			button3.setText("");
			
			button4.setEnabled(true);
			button4.setText("");
			
			button5.setEnabled(true);
			button5.setText("");
			
			button6.setEnabled(true);
			button6.setText("");
			
			button7.setEnabled(true);
			button7.setText("");
			
			button8.setEnabled(true);
			button8.setText("");
			
			button9.setEnabled(true);
			button9.setText("");
			
			textField.setText("X, pick a square");
			
			turn = 1;
			
			
		}
		
		if (e.getSource() == buttonNo) {
			
			System.exit(0);
			
		}
		
		if (e.getSource() == button1) {
			
			turn(button1);
			
		}
		
		if (e.getSource() == button2) {
			
			turn(button2);
			
		}
		
		if (e.getSource() == button3) {
			
			turn(button3);
			
		}
		
		if (e.getSource() == button4) {
			
			turn(button4);
			
		}
		
		if (e.getSource() == button5) {
			
			turn(button5);
			
		}
		
		if (e.getSource() == button6) {
			
			turn(button6);
			
		}
		
		if (e.getSource() == button7) {
			
			turn(button7);
			
		}
		
		if (e.getSource() == button8) {
			
			turn(button8);
			
		}
		
		if (e.getSource() == button9) {
			
			turn(button9);
			
		}
		
	}

	private void turn(JButton b) {
		
		if (panel2.isVisible() == true) {
			
			panel2.setVisible(false);
		}
		
		if (turn % 2 != 0) {
			
			b.setText(x);
			b.setEnabled(false);
			turn++;
			
			if (turn > 5) {
				
				won();
			}
		
			textField.setText("O, pick a square");
			
			
		}
		
		else {
			
			b.setText(o);
			b.setEnabled(false);
			turn++;
			if (turn > 5) {
				
				won();
			}
			textField.setText("X, pick a square");
			
		}
		
	}

	private void won() {
		
		panel2.setVisible(true);
		textField.setText("Someone wins. Restrat Game?");
		
	}
	
}
