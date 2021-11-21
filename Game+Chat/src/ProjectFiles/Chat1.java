package ProjectFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class ClientMessage2 extends Thread{
	
	public void run() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG","qm1cFc5NVG","dLC6gkxP1s");  
			Scanner scan=new Scanner(System.in);
			int prev=0;
//			int i;
			int k=0;
//			int choice;
			int count;
			boolean loop=true;
			
			while(loop) {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from Client1");
				
				String[] ClientMsg=new String[30];
				int j=0;
				while(rs.next()) {
					if(j<prev) {
						//System.out.print("\n You 1 : ");
					//	scan.next();
					}
					else {
						ClientMsg[j]=rs.getString(2);
						System.out.print("\n client : "+ClientMsg[j]);
					}
					j++;
					//System.out.print("\n You 2 : ");
			}
				if(k==0) {
//					System.out.print("\n You 3 : ");
					k++;
				}
				prev=j;
				Thread.sleep(100);
				
		}
		}
		catch(Exception e) {
			System.out.println(" "+e);
		}
		
	}
	
}
class YourMessage2 extends Thread{
	
	public void run() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG","qm1cFc5NVG","zfUDV3V3YB");  
			Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/qm1cFc5NVG","qm1cFc5NVG","dLC6gkxP1s");
			System.out.println("loading message...");
			Scanner scan=new Scanner(System.in);
//			int prev=0;
//			int i;
//			int choice;
			int count;
			boolean loop=true;
			while(loop) {
//					Statement stmt=con.createStatement();
//					int[] id=new int[30];
//					String[] message=new String[30];
//					ResultSet rs=stmt.executeQuery("Select * from Client2");
//					i=0;
//					while(rs.next()) {
//						id[i]=rs.getInt(1);
//						message[i]=rs.getString(2);
//						i++;
//					}
					count=0;
//					choice=0;
						//Thread.sleep(150);
						
						System.out.println("message : ");
						String msg=scan.nextLine();
						String query="Insert into Client2(id,message)"+"values(?,?)";
						PreparedStatement preparedStmt = con.prepareStatement(query);
						preparedStmt.setInt(1, count);
						preparedStmt.setString(2, msg);
						preparedStmt.execute();
					
					}
				scan.close();	
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
		}
		
	}
	
}

public class Chat1{
	public static void main (String[] args) {
		
		try { 
			
			ClientMessage2 c=new ClientMessage2();
			c.start();
			YourMessage2 y=new YourMessage2();
			y.start();
		
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
		}
		
		
	}
}