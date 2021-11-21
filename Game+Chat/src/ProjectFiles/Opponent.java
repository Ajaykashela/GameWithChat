package ProjectFiles;

import java.util.*;
import java.sql.*;


public class Opponent {

	static Connection con;

	static Scanner scan;

	static Statement stmt;
	
	Opponent(){
		try {

			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG","qm1cFc5NVG","dLC6gkxP1s");

			stmt = con.createStatement();

		} catch (Exception e) {

			System.out.println("Error : " + e);

		}
	}

	public int HostTheLobby() {

		try {

			int code = 0;

			code = (int)(Math.random()*10000);

			System.out.println(code);

			EnterCodeInDataBase(code); // use unique key on the table so that the two games from same password does not

			// System.out.println(result);

			// get created.

			System.out.println("Lobby Code is : " + code);
			
			return code;

		} catch (Exception e) {

			System.out.println("Error : " + e);

		}
		return 0;
	}

	private void EnterCodeInDataBase(int code) {

		try {

			String query = " insert into Lobby (code)" + " values (?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, code);
			
			preparedStmt.execute();
			
			
			
			//Statement stmt = con.createStatement();	      
	         
			query = "CREATE TABLE "+"a"+code+" (id INTEGER not NULL, message VARCHAR(255))";
			
			preparedStmt = con.prepareStatement(query);

			preparedStmt.execute();			

			query = "CREATE TABLE "+"b"+code+" (id INTEGER not NULL, message VARCHAR(255))";
			
			preparedStmt = con.prepareStatement(query);

			preparedStmt.execute();			

			

		} catch (Exception e) {
			
			System.out.println("Error : "+e);
			
			//HostTheLobby();

		}

	}

	int checkTheCode(int code) {

		try {

			String query = " select code from Lobby where code=(?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, code);

			preparedStmt.execute();
			
			ResultSet rs = preparedStmt.getResultSet(  );

			if (rs.next())
				
				return 0;
			
			else
				
				return 1;
			

		} catch (Exception e) {

			System.out.println("Error : " + e);

		}
		return 2;

	}

	public void JoinTheLobby() {

		try {

			System.out.println("Enter the game code : ");

			int code = scan.nextInt();

			System.out.println("Your code is being checked ...code : " + code);

			@SuppressWarnings("unused")
			int returned = checkTheCode(code);

		} catch (Exception e) {

			System.out.println("Error : " + e);

		}

	}

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG","qm1cFc5NVG","dLC6gkxP1s");

			stmt = con.createStatement();

		} catch (Exception e) {

			System.out.println("Error : " + e);

		}

//		System.out.println(
//				"\n1.Online With Friends\n2.Offline With Freinds\n3.Offline with Computer\n4.host\n5.join\nEnter your choice : ");
//
//		scan = new Scanner(System.in);
//		
//		int ch = scan.nextInt();

	//	switch (ch) {
//
////		 case 2:OfflineSimpleGame(); //call only match nothing else just the basic tic
////		// tac toe
////		 break;
//
//		// case 3:OfflineWithComputer();//call match with comptuter method . generate
//		// simple number from 1 to 9 and place it if possible else generate other one.
//		// break;
//
//		case 4:
//			HostTheLobby();// Host the match generate simple code and add it to data base
//			break;
//
//		case 5:
//			JoinTheLobby();// Enter the code and join lobby
//			break;
//
//		}

	}

}