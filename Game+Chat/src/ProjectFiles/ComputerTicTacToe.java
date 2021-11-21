package ProjectFiles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class ComputerTicTacToe extends JFrame {

	static final int EMPTY = 0;
	static final int NONE = 0;
	static final int USER = 1;
	static final int COMPUTER = 2;
	static final int STALEMATE = 3;

	static int turn = USER;

	static int[][] board = new int[3][3];

	static JFrame f;

	static JButton b[];

	static JButton replay;
	
	ComputerTicTacToe(){
		
		//int c = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = -1;

		printBoard();
		
	}

	public static void main(String[] args) {

	//	int c = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = -1;

		printBoard();
	}

	static void printBoard() {

		f = new JFrame();

		f.setLayout(null);

		b = new JButton[9];

		JTextField t=new JTextField(); 
		
		Font newTextFieldFont=new Font(t.getFont().getName(),t.getFont().getStyle(),30);
		
		t.setFont(newTextFieldFont);
		
		int x = 0, y = 10;

		int width = 100, height = 100;

		for (int i = 1; i <= 9; i++) {

			b[i - 1] = new JButton("" + i);
			
			//b[i-1].setText("");

			b[i - 1].setBounds(x, y, width, height);

			f.add(b[i - 1]);
			
			b[i-1].setFont(newTextFieldFont);

			b[i - 1].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					int tempMove = Integer.parseInt(e.getActionCommand());

					b[tempMove-1].setText("X");

					b[tempMove-1].setEnabled(false);

					System.out.println("t/3"+(tempMove) / 3+"t%3"+(tempMove) % 3);
					
					if(tempMove==0) {
						board[0][0]=1;
					}
					else
							board[(tempMove-1) / 3][(tempMove-1) % 3] = 1;

					int winner = checkWinner(board);

					System.out.println(winner);

					if (winner == 1) {

						System.out.println("You won");
						
						JOptionPane.showMessageDialog(f, "You won ... :)", "Alert",
								JOptionPane.WARNING_MESSAGE);

					}

					else {
					}

				//	System.out.print("out");

					tempMove = computer_move();

					System.out.println(tempMove);
					
					if(tempMove==0) {
					
						b[tempMove].setText("0");

						b[tempMove].setEnabled(false);
						
					}
					else {
						
					
						b[tempMove-1].setText("0");

						b[tempMove-1].setEnabled(false);
					
					}
					
					if(tempMove==0) {
						board[0][0]=2;
					}
					else
						board[(tempMove-1) / 3][(tempMove-1) % 3] = 2;

					winner = checkWinner(board);

					if (winner == 2) {

						System.out.println("Computer won");

						JOptionPane.showMessageDialog(f, "Computer won ... :)", "Alert",
								JOptionPane.WARNING_MESSAGE);
						
					}

				}
			});

			x += 100;

			if (i % 3 == 0) {

				x = 0;

				y += 100;
			}

		}

		f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		f.setVisible(true);

		f.setSize(310, 500);

	}

	// See if the game is over
	public static int checkWinner(int[][] board) {
		// Check if someone won
		// Check horizontals

//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++)
//				System.out.print(board[i][j]+" ");
//			System.out.println();
//		}

		// top row
		if ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]))
			return board[0][0];

		// middle row
		if ((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]))
			return board[1][0];

		// bottom row
		if ((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]))
			return board[2][0];

		// Check verticals

		// left column
		if ((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]))
			return board[0][0];

		// middle column
		if ((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]))
			return board[0][1];

		// right column
		if ((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]))
			return board[0][2];

		// Check diagonals
		// one diagonal
		if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]))
			return board[0][0];

		// the other diagonal
		if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]))
			return board[0][2];

		//System.out.print("in checker");

		return 3;

	}

	// Generate a random computer move
	public static int computer_move() {
		
		int move = (int) (Math.random() * 9);
		
		move=0;
		
		if(board[0][0]==-1) {
			return 0;
		}
		
		while (move==0 || board[(move-1) / 3][(move-1) % 3] != -1) {
			//System.out.println("\n here : "+board[(move-1) / 3][(move-1) % 3]);
			move = (int) (Math.random() * 9);
			System.out.println("\n move : "+move);
		}
		
		return move;
	
	}
}
