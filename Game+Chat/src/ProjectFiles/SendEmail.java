package ProjectFiles;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

public class SendEmail {

	public static void main(String[] args) {

		System.out.println(sendEmail("ajaydeepsangbhai@gmail.com","1111",0));
	}
	
	public static String sendEmail(String emailAddress, String conformationCode, int choice) {
		
		String to = emailAddress;
		
		System.out.println(to);

		String subject = "not intialized";

		String message = "not intialized";
		
	//	String host = "smtp.gmail.com";

		if (choice == 0) {

			subject = "Conformation Email for TicTacToe game";

			message = "<h3>Hello there,</h3> <h3> thank you for joining our game your conformation code is : </h3><h2>" + conformationCode
					+ " </h2>" + " <h3>Thank You</h3><h6>if you think it's a mistake than please ignore the message .</h6>";

		}

		else if (choice == 1) {

			subject = "Password change Conformation Email for TicTacToe game";

//			message = "Hello there, \n\tthank you for joining our game your conformation code is : " + conformationCode
//					+ " \n \nif you think it's a mistake than please kindly reply to this email . we will try to solve your problem ..."
//					+ " \n\nThank You";
			message="<h3>Hello there,</h3><h3> Your conformation code is : </h3><h2>" + conformationCode
			+ " </h2><h6>if you think it's a mistake than please kindly reply to this email . we will try our best to solve your problem ...</h6>" + " <h3>Thank You</h3>";

		}

		//String from = "tictactoegame702@gmail.com";

		Properties properties = System.getProperties();

		// System.out.println(" "+properties);
		
		System.out.println(conformationCode);
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("tictactoegame702@gmail.com", "9662565814");

			}

		});

		MimeMessage m = new MimeMessage(session);

		// session.setDebug(true);

		try {

		m.setFrom();

		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		m.setSubject(subject);

		m.setContent(message, "text/html; charset=utf-8" );
		//m.setText(message);

		Transport.send(m);

//			System.out.println("\n Sent successfully...................");

		}

		catch (Exception e) {

			return "Error occurd : "+e;

		}
		
		return "done";

	}

}