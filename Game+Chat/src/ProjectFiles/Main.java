package ProjectFiles;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

class MyFrame {

	static JTextField usernameF;

	static JPasswordField pass;

	static JTextField Address;

	static JTextField email;

	static JTextField mobile;

	static JTextField code;

	void MyFrameLogin() {

		usernameF = new JTextField();

		pass = new JPasswordField();

		usernameF.setBounds(150, 80, 220, 30);

		usernameF.setColumns(10);

		pass.setBounds(150, 130, 220, 30);

		pass.setColumns(10);

		final JFrame frame = new JFrame("LOGIN");

		JLabel labelMain = new JLabel("LOGIN FORM");

		labelMain.setBounds(110, 0, 200, 50);

		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel label1 = new JLabel("User Name : ");

		label1.setBounds(20, 70, 150, 50);

		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel label2 = new JLabel("Password : ");

		label2.setBounds(20, 120, 150, 50);

		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton b1 = new JButton("login");

		b1.setBounds(20, 200, 140, 40);

		JButton b2 = new JButton("sign up");

		b2.setBounds(230, 200, 140, 40);

		JButton b3 = new JButton("Guest");

		b3.setBounds(20, 250, 140, 40);

		JButton b4 = new JButton("Forgot password");

		b4.setBounds(230, 250, 140, 40);

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String user = usernameF.getText();

				@SuppressWarnings("deprecation")

				String passwordS = pass.getText();

				if (user.length() == 0 && passwordS.length() == 0)

					JOptionPane.showMessageDialog(frame, "please enter username and password.", "Empty field",
							JOptionPane.ERROR_MESSAGE);

				else if (user.length() == 0 || passwordS.length() == 0) {

					if (user.length() == 0)
						JOptionPane.showMessageDialog(frame, "please enter username", "Empty field",
								JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(frame, "please enter password.", "Empty field",
								JOptionPane.ERROR_MESSAGE);
				}

				else {

					LoginSystem i = new LoginSystem();

					int returnedValue = i.login(user, passwordS);

					if (returnedValue == 0) {

						frame.setVisible(false);

						HomePage(user);

					}

					else if (returnedValue == 1) {

						JOptionPane.showMessageDialog(frame, "Username or password is invalid", "Login Failed",
								JOptionPane.ERROR_MESSAGE);

					}

				}

			}
		});

		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

				MyFrameSignUp();

			}

		});

		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

				guest();

			}

		});

		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

				forgotPassWord();

			}

		});

		frame.add(pass);

		frame.add(usernameF);

		frame.add(labelMain);

		frame.add(b1);

		frame.add(b2);

		frame.add(b3);

		frame.add(b4);

		frame.add(label1);

		frame.add(label2);

		frame.setSize(400, 350);

		frame.setLayout(null);

		//frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

	}

	public void guest() {

		usernameF = new JTextField();

		usernameF.setBounds(150, 120, 220, 30);

		final JFrame frame = new JFrame("GUEST");

		JLabel labelMain = new JLabel("Guest");

		labelMain.setBounds(150, 0, 200, 50);

		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel label1 = new JLabel("User Name : ");

		label1.setBounds(20, 110, 150, 50);

		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton b1 = new JButton("Submit");

		b1.setBounds(20, 250, 140, 40);

		JButton b2 = new JButton("back");

		b2.setBounds(220, 250, 140, 40);

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (usernameF.getText().length() == 0) {

					JOptionPane.showMessageDialog(frame, "please enter username for your guest account!", "Empty field",
							JOptionPane.WARNING_MESSAGE);

				}

				else {

					frame.setVisible(false);

					HomePage(usernameF.getText() + "_guest");

				}

			}
		});

		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

				MyFrameLogin();

			}
		});

		frame.add(b2);

		frame.add(b1);

		frame.add(labelMain);

		frame.add(label1);

		frame.add(usernameF);

		frame.setSize(400, 350);

		frame.setLayout(null);

		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

	}

	public void forgotPassWord() {

		usernameF = new JTextField();

		pass = new JPasswordField();

		usernameF.setBounds(150, 100, 220, 30);

		usernameF.setColumns(10);

		pass.setBounds(150, 150, 220, 30);

		pass.setColumns(10);

		final JFrame frame = new JFrame("FORGOT PASSWORD");

		JLabel labelMain = new JLabel("Forgot password");

		labelMain.setBounds(100, 0, 250, 50);

		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel label1 = new JLabel("User Name : ");

		label1.setBounds(20, 90, 150, 50);

		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel label2 = new JLabel("NewPassword : ");

		label2.setBounds(20, 140, 150, 50);

		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton b1 = new JButton("Submit");

		b1.setBounds(20, 240, 140, 40);

		JButton b2 = new JButton("Back");

		b2.setBounds(220, 240, 140, 40);

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String user = usernameF.getText();

				@SuppressWarnings("deprecation")

				String passwordS = pass.getText();

				LoginSystem i = new LoginSystem();

				String returnedValue = i.checkExistance(user);

				//System.out.println(returnedValue);
				
				if (returnedValue.equals("doesn't exist")) {

					JOptionPane.showMessageDialog(frame, "User Does not Exist!!!", "Alert",
							JOptionPane.WARNING_MESSAGE);

				}

				else {

					if (user.length() == 0 || passwordS.length() == 0) {

						JOptionPane.showMessageDialog(frame,
								"Please enter a new password.\nnew password field should not be empty.", "Empty field",
								JOptionPane.ERROR_MESSAGE);

					} else {

						SendEmail emailsenderObj = new SendEmail();

						String conformationCode = "" + (int) ((Math.random()) * 10000);
						
						//System.out.println(returnedValue);						

						String temp = emailsenderObj.sendEmail(returnedValue, conformationCode, 1);

						if (temp == "done") {

							AccountCreated(conformationCode, i, returnedValue, user, passwordS, 1);

							frame.setVisible(false);
						}

						else
							JOptionPane.showConfirmDialog(frame, temp, "Email Error", JOptionPane.ERROR_MESSAGE);

					}
				}

			}
		});

		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

				MyFrameLogin();

			}
		});

		frame.add(b2);

		frame.add(pass);

		frame.add(usernameF);

		frame.add(labelMain);

		frame.add(b1);

		frame.add(label1);

		frame.add(label2);

		frame.setSize(400, 350);

		frame.setLayout(null);

		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

	}

	public void MyFrameSignUp() {

		usernameF = new JTextField();

		pass = new JPasswordField();

		email = new JTextField();

		usernameF.setBounds(150, 130, 150, 30);

		email.setBounds(150, 80, 150, 30);

		pass.setBounds(150, 180, 150, 30);

		final JFrame frame = new JFrame("SIGN UP");

		JLabel labelMain = new JLabel("SIGN UP FORM");

		labelMain.setBounds(100, 0, 250, 50);

		labelMain.setFont(new Font("Tahoma", Font.PLAIN, 30));

		JLabel label1 = new JLabel("email id : ");

		label1.setBounds(50, 70, 100, 50);

		label1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel label2 = new JLabel("password : ");

		label2.setBounds(50, 170, 100, 50);

		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel label3 = new JLabel("username : ");

		label3.setBounds(50, 120, 100, 50);

		JButton b1 = new JButton("Back");

		label3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		b1.setBounds(220, 250, 140, 40);

		JButton b2 = new JButton("sign up");

		b2.setBounds(20, 250, 140, 40);

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

				MyFrameLogin();

			}

		});

		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String user = usernameF.getText();

				@SuppressWarnings("deprecation")

				String passwordS = pass.getText();

				String emailAddress = email.getText();

				if (user.length() == 0 || passwordS.length() == 0) {

					JOptionPane.showMessageDialog(frame, "please enter username and password.", "Empty field",
							JOptionPane.ERROR_MESSAGE);

				}

				else {

					LoginSystem i = new LoginSystem();

					String returnedValue = i.checkExistance(emailAddress, user);

					if (returnedValue.equals("Username is taken")) {

						JOptionPane.showMessageDialog(frame, returnedValue, "Alert", JOptionPane.WARNING_MESSAGE);

					}

					else if (returnedValue.equals("account with this email already exist!!!")) {

						JOptionPane.showMessageDialog(frame, returnedValue, "Alert", JOptionPane.WARNING_MESSAGE);

					}

					else {

						SendEmail emailsenderObj = new SendEmail();

						String conformationCode = "" + (int) ((Math.random()) * 10000);

						String temp = emailsenderObj.sendEmail(emailAddress, conformationCode, 0);

						if (temp == "done") {

							AccountCreated(conformationCode, i, emailAddress, user, passwordS, 0);

							frame.setVisible(false);
						}

						else {

							System.out.println(temp);
							
							JOptionPane.showMessageDialog(frame, "Email is invalid or smtp is not responding.",
									"Email Error", JOptionPane.ERROR_MESSAGE);
						}

					}
				}
			}

		});

		frame.add(pass);

		frame.add(usernameF);

		frame.add(email);

		frame.add(labelMain);

		frame.add(b1);

		frame.add(b2);

		frame.add(label1);

		frame.add(label2);

		frame.add(label3);

		frame.setSize(400, 350);

		frame.setLayout(null);

		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

	}

	public void HomePage(String user) {

//		JFrame f = new JFrame("Home Page");
//
//		JLabel label1 = new JLabel("Hello , " + user);
//
//		label1.setBounds(120, 80, 400, 50);
//
//		label1.setFont(new Font("Tahoma", Font.PLAIN, 32));
//
//		f.add(label1);
//
//		f.setSize(400, 350);
//
//		f.setLayout(null);
//
//		f.setLocationRelativeTo(null);
//
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//		f.setVisible(true);
		
		OpponentGUI o=new OpponentGUI();
		

	}

	public void AccountCreated(final String conformationCode, final LoginSystem i, final String email,
			final String user, final String pass, final int choice) {

		final JFrame f = new JFrame("Confirm");

		f.setLayout(null);

		JLabel label1 = new JLabel("Confirm email");

		label1.setBounds(120, 0, 200, 50);

		JLabel label2 = new JLabel("A code has been sent to " + email + "");

		label2.setBounds(50, 50, 300, 50);

		JLabel label3 = new JLabel("Please Enter The code : ");

		label3.setBounds(50, 100, 150, 50);

		code = new JTextField();

		code.setBounds(200, 110, 100, 30);

		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton b1 = new JButton("submit");

		b1.setBounds(140, 170, 100, 30);

		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String usercode = code.getText();

				if (conformationCode.equals(usercode)) {

					if (choice == 0)

						i.signup(email, user, pass);

					else if (choice == 1)

						i.forgotPassword(user, pass);

					f.setVisible(false);

					HomePage(user);

				}

				else {

					code.setText("");

					JOptionPane.showMessageDialog(f, "wrong code.", "Alert", JOptionPane.WARNING_MESSAGE);

				}

			}

		});

		f.add(b1);

		f.add(label1);

		f.add(label2);

		f.add(label3);

		f.add(code);

		f.setSize(400, 350);

		f.setLocationRelativeTo(null);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);

	}

}

class LoginSystem {

	Connection con;

	Statement stmt;

	ResultSet rs;

	String[] emails;

	String[] usernames;

	String[] passwords;

	int i;

	LoginSystem() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG","qm1cFc5NVG","dLC6gkxP1s");

			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from login");

			emails = new String[20];

			usernames = new String[20];

			passwords = new String[20];

			i = 0;

			while (rs.next()) {

				emails[i] = rs.getString(1);

				usernames[i] = rs.getString(2);

				passwords[i] = rs.getString(3);

				i++;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public void forgotPassword(String user, String pass) {

		try {

			String query = " update login set password=? where username=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(2, user);

			preparedStmt.setString(1, pass);

			preparedStmt.execute();

		}

		catch (Exception e) {

			System.out.println(e);

		}

	}

	public String checkExistance(String username) {

		for (int i = 0; i < usernames.length; i++) {

			if (username.equals(usernames[i])) {

				return emails[i];

			}

		}

		return "doesn't exist";

	}

	public String checkExistance(String Email, String username) {

		for (int i = 0; i < usernames.length; i++) {

			if (username.equals(usernames[i])) {

				return "Username is taken";

			}

			else if (Email.equals(emails[i])) {

				return "account with this email already exist!!!";

			}

		}

		return "good to go";

	}

	public void signup(String Email, String username, String pass) {

		try {

			String query = " insert into login (email,username,password)" + " values (?, ? ,?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, Email);

			preparedStmt.setString(2, username);

			preparedStmt.setString(3, pass);

			preparedStmt.execute();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

	public int login(String namei, String passi) {

		try {

			boolean login = false;

			for (int j = 0; j < i; j++) {

				if (namei.equals(usernames[j]) && passi.equals(passwords[j])) {

					login = true;

				}

			}

			if (login) {

				return 0;

			}

			else {

				return 1;

			}

		} catch (Exception e) {

			System.out.println(e);

		}

		return 2;

	}
}

public class Main {

	public static void main(String args[]) {

		try {

			MyFrame framm = new MyFrame();

			framm.MyFrameLogin();

		}

		catch (Exception e) {

		}

	}
}