package ProjectFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class OpponentGUI extends JFrame{

	JButton OnlineHost;
	
	JButton OnlineJoin;
	
	JButton OfflineWithFriend;
	
	JButton OfflineWithComputer;
	
	JFrame f;
	
	OpponentGUI(){
		
		Opponent Opponent=new Opponent();
		
		f=new JFrame("Opponent");
		
		//f.setLocationRelativeTo(null);
		
		f.setLayout(null);
		
		f.setVisible(true);

		f.setSize(400,300);
		
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		OnlineHost=new JButton("Host Game Online");
		
		OnlineHost.setBounds(10,10,150,50);
		
		OnlineJoin=new JButton("Join Game Online");
		
		OnlineJoin.setBounds(200,10,150,50);
		
		OfflineWithFriend=new JButton("Offline With Friend");
		
		OfflineWithFriend.setBounds(10,110,150,50);
		
		OfflineWithComputer=new JButton("Offline With Computer");
		
		OfflineWithComputer.setBounds(200,110,150,50);
		
		f.add(OfflineWithComputer);
		
		f.add(OfflineWithFriend);
		
		f.add(OnlineHost);
		
		f.add(OnlineJoin);
		
		OnlineHost.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				int Code = Opponent.HostTheLobby();
				
				JOptionPane.showMessageDialog(f, "Lobby created code : "+Code, "Alert",
						JOptionPane.WARNING_MESSAGE);
				
				@SuppressWarnings("unused")
				ChatTicTacToe c=new ChatTicTacToe(""+Code);
				
			}
		
		});
		
		
		OfflineWithComputer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		
		});
		
		OnlineJoin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				JFrame TakeCode=new JFrame("Enter the Code");

				TakeCode.setLayout(null);
				
				TakeCode.setVisible(true);

				TakeCode.setSize(300,170);
				
				JLabel TakeCodeFromUser=new JLabel("Code : ");
				
				TakeCodeFromUser.setBounds(10,10,100,50);
				
				JTextField Code=new JTextField();
				
				Code.setBounds(120,10,100,50);
				
				JButton submit=new JButton("Submit");
				
				submit.setBounds(70,70,100,50);
				
				TakeCode.add(submit);
				
				TakeCode.add(Code);
				
				TakeCode.add(TakeCodeFromUser);
				
				submit.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						TakeCode.setVisible(false);
						
						int userCode=Integer.parseInt(Code.getText());
						
						int check = Opponent.checkTheCode(userCode);
						
						if(check==0) {
							
							JOptionPane.showMessageDialog(f, "Lobby Found", "Alert",
									JOptionPane.WARNING_MESSAGE);
							
							@SuppressWarnings("unused")
							ChatTicTacToe2 c=new ChatTicTacToe2(Code.getText());
							
						}
						else if(check==1){
							JOptionPane.showMessageDialog(f, "Lobby Not Found", "Alert",
									JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(f, "Unexpected Error!!!", "Alert",
									JOptionPane.WARNING_MESSAGE);
						}
						
					}
				
				});
				
				
				
			}
		
		});
		
		OfflineWithComputer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				ComputerTicTacToe OfflineComputer=new ComputerTicTacToe();
				
			}
		
		});
		
		OfflineWithFriend.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("unused")
				TicTacToe tictactoe=new TicTacToe();
				
			}
		
		});
		
	}
	
	public static void main(String []args) {
		
		new OpponentGUI();
		
	}
	
	
}
