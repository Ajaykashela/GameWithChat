package ProjectFiles;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

@SuppressWarnings("serial")

public class ChatTicTacToe2 extends JFrame implements ActionListener {

	
	static String TableName;
	
	static String[] board = new String[9];

	static String turn;

	static int moves = 0;

	static String winner;

	static JTextField t;

	static JFrame f;
	
	static int MyTurnOrNot=1;

	static JButton b[];

	static JButton replay;

	static JTextArea chat;

	static JTextField WriteMessage;

	static JButton send;

	static YourMessageOther YourMessageOther;

	static ClientMessageOther ClientMessage;

	static JScrollPane sc;
	
	ChatTicTacToe2(String Code){
		
		First();
		
		turn = "X";

		TableName=Code;
		
		System.out.println(TableName);
		
		for (int i = 1; i <= 9; i++) {

			board[i - 1] = "" + i;

		}

		printBoard();
		
	}

	static void First() {

		YourMessageOther = new YourMessageOther();

		ClientMessage = new ClientMessageOther();

		ClientMessage.start();

	}

	void printBoard() {

		f = new JFrame();

		chat = new JTextArea();

		chat.setBounds(320, 10, 400, 300);

		sc = new JScrollPane(chat);

		sc.setBounds(320, 10, 400, 300);

		f.add(sc);

		WriteMessage = new JTextField();

		WriteMessage.setBounds(320, 320, 200, 50);

		send = new JButton("Send");

		send.setBounds(520, 320, 200, 50);

		f.add(WriteMessage);

		f.add(send);

		// f.add(chat);

		f.setLayout(null);

		t = new JTextField();

		t.setBounds(100, 320, 200, 50);

		f.add(t);

		final Font newTextFieldFont = new Font(t.getFont().getName(), t.getFont().getStyle(), 0);

		Font newButtonFont = new Font(t.getFont().getName(), t.getFont().getStyle(), 20);

		b = new JButton[9];

		int x = 0, y = 10;

		int width = 100, height = 100;

		for (int i = 1; i <= 9; i++) {

			b[i - 1] = new JButton("" + i);

			b[i - 1].setBounds(x, y, width, height);

			f.add(b[i - 1]);

			b[i - 1].addActionListener(this);

			b[i - 1].setFont(newTextFieldFont);

			x += 100;

			if (i % 3 == 0) {

				x = 0;

				y += 100;
			}

		}

		replay = new JButton("Replay");

		replay.setFont(newButtonFont);

		replay.setBounds(0, 320, 100, 50);

		f.add(replay);

		replay.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				for (int i = 1; i <= 9; i++) {

					b[i - 1].setText("" + i);

					b[i - 1].setFont(newTextFieldFont);

					board[i - 1] = "" + i;

					turn = "X";

					moves = 0;

					b[i - 1].setEnabled(true);
				}

				t.setText("");

			}

		});

		send.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.out.println("0");

				YourMessageOther.SendMessage(WriteMessage.getText());

				System.out.println("1");

				chat.setText(chat.getText() + "You : " + WriteMessage.getText()+ "\n" );

				System.out.println("2");

				// Add message to data base table so that the other user can see it.

				// for this use the code of chat1 or chat2.java files which are located in
				// FinalProject folder.

				WriteMessage.setText(" ");

			}

		});

		//f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		f.setVisible(true);

		f.setSize(750, 500);

	}

	
	public void actionPerformed(ActionEvent e) {

		String tempMove = e.getActionCommand();

		int opponentButton=0;
		
		//use less
		
			Font newTextFieldFont = new Font(t.getFont().getName(), t.getFont().getStyle(), 30);
	
			t.setFont(newTextFieldFont);

		 //
			
		int tempMoveInt = 0;

		try {

			tempMoveInt = Integer.parseInt(tempMove);

		} catch (Exception ex) {

			t.setText("Invalid Move");

		}

		if (("" + tempMove).equalsIgnoreCase(board[tempMoveInt - 1]) && MyTurnOrNot==0) {

			YourMessageOther.SendMessage(tempMove+"#");
			
			b[opponentButton].setText("0");
			
			System.out.println("6:46 here...");
			
			board[tempMoveInt - 1] = "0";
			
			//t.setText(turn);

			moves++;
			
			b[opponentButton].setText("0");

			winner = checkWinner();

			changeBoard();
			
			MyTurnOrNot=1;

		}

		else {

			t.setText("Invalid Move.");

		}

		if (winner != "none") {

			t.setText(winner + " has won.");

			// System.out.println(winner+" has won.");
			
			for (int i = 0; i < 9; i++)
				b[i].setEnabled(false);
			
			
		}

		else if (moves == 9) {

			t.setText("It's a draw.");

			// System.out.println("It's a draw.");

		}

		winner = checkWinner();

	}
	
	static void changeBoard() {

		Font newTextFieldFont = new Font(t.getFont().getName(), t.getFont().getStyle(), 90);

		for (int i = 0; i < 9; i++) {

			if (board[i] == "X" || board[i] == "0") {

				b[i].setText(board[i]);

				b[i].setFont(newTextFieldFont);

			}

		}

	}
	

	public static void main(String[] args) {

		First();

		ChatTicTacToe2 t = new ChatTicTacToe2(TableName);

		turn = "X";

		for (int i = 1; i <= 9; i++) {

			board[i - 1] = "" + i;

		}

		t.printBoard();

	}

	static String checkWinner() {

		if (board[0] == board[1] && board[1] == board[2])
			return board[0];

		else if (board[3] == board[4] && board[4] == board[5])
			return board[3];

		else if (board[6] == board[7] && board[7] == board[8])
			return board[6];

		else if (board[0] == board[4] && board[4] == board[8])
			return board[0];

		else if (board[2] == board[4] && board[4] == board[6])
			return board[2];

		else if (board[0] == board[3] && board[3] == board[6])
			return board[0];

		else if (board[1] == board[4] && board[4] == board[7])
			return board[1];

		else if (board[2] == board[5] && board[5] == board[8])
			return board[2];

		return "none";
	}

}

//Here is the code for JDBC or backend stuff

class ClientMessageOther extends Thread {

	public void run() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG", "qm1cFc5NVG",
					"dLC6gkxP1s");

			int prev = 0;

			int k = 0;

			boolean loop = true;

			while (loop) {

				Statement stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery("Select * from b"+ChatTicTacToe2.TableName);

				String[] ClientMsg = new String[30];

				int j = 0;

				while (rs.next()) {

					if (j < prev) {

					} else {
						
						

						ClientMsg[j] = rs.getString(2);
						
						
						if(ClientMsg[j].contains("#")) {
							
							ChatTicTacToe2.chat.setText(ChatTicTacToe2.chat.getText() + "Client has made a move "+ClientMsg[j].charAt(0)+"  .... " + ClientMsg[j] + "\n");
							
							ChatTicTacToe2.b[((int)ClientMsg[j].charAt(0))-49].setText("X");
							
							ChatTicTacToe2.board[((int)ClientMsg[j].charAt(0))-49]="X";
							
							ChatTicTacToe2.changeBoard();
							
							String winner = ChatTicTacToe2.checkWinner();
							
							if(winner=="none") {}
							
							else {
								
								ChatTicTacToe2.t.setText(winner+" Has Won.");
								
								for (int i = 0; i < 9; i++)
									ChatTicTacToe2.b[i].setEnabled(false);
								
							}
							
							ChatTicTacToe2.MyTurnOrNot=0;
							
							//ChatTicTacToe.t.setText("");
							
						//	System.out.println("6:46 here");
							
						}
						
						else {
						
							ChatTicTacToe2.chat.setText(ChatTicTacToe2.chat.getText() + "Client : " + ClientMsg[j] + "\n");
							
						}
						// System.out.print("\n client : "+ClientMsg[j]);

					}

					j++;
					
					//System.out.println("6:46 here.");

					// System.out.print("\n You 2 : ");
				}
				if (k == 0) {
//					System.out.print("\n You 3 : ");
					k++;
				}
				
				//System.out.println("6:46 here..");
				
				prev = j;

				Thread.sleep(100);

			}
		} catch (Exception e) {

			System.out.println(ChatTicTacToe2.TableName);
			
			e.printStackTrace();

		}

	}

}

class YourMessageOther {

	public void SendMessage(String msg) {

		try {

			System.out.print(".");

			Class.forName("com.mysql.jdbc.Driver");

			System.out.print("..");

			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG", "qm1cFc5NVG",
					"dLC6gkxP1s");

			System.out.print("...");

			int count = 0;

			String query = "Insert into a"+ChatTicTacToe2.TableName+"(id,message)" + "values(?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, count);

			preparedStmt.setString(2, msg);

			System.out.print("....");

			preparedStmt.execute();

			System.out.print(".....");

		} catch (Exception e) {

			System.out.println("Exception : " + e);

		}

	}

}
