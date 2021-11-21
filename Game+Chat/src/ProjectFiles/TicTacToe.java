package ProjectFiles;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame implements ActionListener{

	static String[] board=new String[9];
	
	static String turn;
	
	static int moves=0;
	
	static String winner;
	
	static JTextField t;
	
	static JFrame f;
	
	static JButton b[];
	
	static JButton replay;
	
	TicTacToe(){
		
		turn="X";
		
		for(int i=1;i<=9;i++) {
			
			board[i-1]=""+i;
			
		//	System.out.println(board[i-1]);
			
		}
		
		printBoard();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String tempMove=e.getActionCommand();
		
		Font newTextFieldFont=new Font(t.getFont().getName(),t.getFont().getStyle(),30);
		
		t.setFont(newTextFieldFont);
		
		int tempMoveInt = 0;
		
		try {
			
			tempMoveInt=Integer.parseInt(tempMove);
			
		}
		catch(Exception ex) {
			
			t.setText("Invalid Move");
			
		}
		
		if((""+tempMove).equalsIgnoreCase(board[tempMoveInt-1])) {
			
			board[tempMoveInt-1]=turn;
			
			moves++;
			
			if(turn=="X")
			
				turn="0";
			
			else
				
				turn="X";
			
			winner=checkWinner();
			
			changeBoard();
			
		}
		
		else {
	
			t.setText("Already Taken.");
		
		}
		
		if(winner!="none") {
			
			t.setText(winner+" has won.");
		
			//System.out.println(winner+" has won.");
			for(int i=0;i<9;i++)
				b[i]. setEnabled(false);
		}
		
		else if(moves==9) {
			
			t.setText("It's a draw.");
			
			//System.out.println("It's a draw.");
		
		}
		
		winner=checkWinner();
			
	}
	
	 private void changeBoard() {
		
		Font newTextFieldFont=new Font(t.getFont().getName(),t.getFont().getStyle(),90);
		 	 
		for(int i=0;i<9;i++) {
		
			if(board[i]=="X" || board[i]=="0") {
			
				b[i].setText(board[i]);
				
				b[i].setFont(newTextFieldFont);
			
			}
		
		}
		
	}

	void printBoard() {
		
		f=new JFrame();
		
		f.setLayout(null);
		
		t=new JTextField();
		
		f.setLocationRelativeTo(null);
		
		t.setBounds(100, 320, 200, 100);
		
		f.add(t);
		
		final Font newTextFieldFont=new Font(t.getFont().getName(),t.getFont().getStyle(),0);

		Font newButtonFont=new Font(t.getFont().getName(),t.getFont().getStyle(),20);
		
		b=new JButton[9];
		
		int x=0,y=0;
		
		int width=100,height=100;
		
		for(int i=1;i<=9;i++) {
			
			b[i-1] = new JButton(""+i);
		
			b[i-1].setBounds(x,y,width,height);
			
			f.add(b[i-1]);
			
			b[i-1].addActionListener(this);
			
			b[i-1].setFont(newTextFieldFont);
			
			x+=100;
			
			if(i%3==0) {
			
				x=0;
				
				y+=100;
			}
			
		}
		
		
		replay=new JButton("Replay");
		
		replay.setFont(newButtonFont);
		
		replay.setBounds(0, 320, width, height);
		
		f.add(replay);
		
		replay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				for(int i=1;i<=9;i++) {
							
					b[i-1].setText(""+i);
					
					b[i-1].setFont(newTextFieldFont);
					
					board[i-1]=""+i;
					
					turn="X";
					
					moves=0;
					
					b[i-1]. setEnabled(true);
				}
				
				t.setText("");
				
			}
			
		});
		
		f.setVisible(true);
		
		f.setSize(315, 500);
		
	}
	public static void main(TicTacToe t) {
		
//		turn="X";
//		
//		for(int i=1;i<=9;i++) {
//			
//			board[i-1]=""+i;
//			
//		//	System.out.println(board[i-1]);
//			
//		}
//		
//		t.printBoard();
				
	}

	private static String checkWinner() {
		
		if(board[0] == board[1] && board[1] == board[2])
			return board[0];
		
		else if(board[3] == board[4] && board[4] == board[5])
			return board[3];
		
		else if(board[6] == board[7] && board[7] == board[8])
			return board[6];
		
		else if(board[0] == board[4] && board[4] == board[8])
			return board[0];
		
		else if(board[2] == board[4] && board[4] == board[6])
			return board[2];
		
		else if(board[0] == board[3] && board[3] == board[6])
			return board[0];
		
		else if(board[1] == board[4] && board[4] == board[7])
			return board[1];
		
		else if(board[2] == board[5] && board[5] == board[8])
			return board[2];	
		
		return "none";
	}
	
}