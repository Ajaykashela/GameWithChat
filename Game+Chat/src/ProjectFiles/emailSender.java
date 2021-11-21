package ProjectFiles;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;

public class emailSender {

	public String sendEmail(String emailAddress, String conformationCode, int choice) {

		String to = emailAddress;

		String subject = "not intialized";

		String message = "not intialized";

		if (choice == 0) {

			subject = "Conformation Email for TicTacToe game";

			message = "Hello there, \n\tthank you for joining our game your conformation code is : " + conformationCode
					+ " \n \nif you think it's a mistake than please ignore the message ." + " \n\nThank You";

		}

		else if (choice == 1) {

			subject = "Password change Conformation Email for TicTacToe game";

			message = "Hello there, \n\tthank you for joining our game your conformation code is : " + conformationCode
					+ " \n \nif you think it's a mistake than please kindly reply to this email . we will try to solve your problem ..."
					+ " \n\nThank You";

		}

		String from = "YOUR email ID";

		String host = "smtp.gmail.com";

		Properties properties = System.getProperties();

		// System.out.println(" "+properties);

		// System.out.println(conformationCode);

		properties.put("mail.smtp.host", host);

		properties.put("mail.smtp.port", "465");

		properties.put("mail.smtp.ssl.enable", "true");

		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("YOUR EMAIL ID", "YOUR PASSWORD");

			}

		});

		MimeMessage m = new MimeMessage(session);

		// session.setDebug(true);

		try {

			m.setFrom(new InternetAddress(from));

			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			m.setSubject(subject);

			m.setText(message);

			Transport.send(m);

//			System.out.println("\n Sent successfully...................");

		}

		catch (Exception e) {

			return "Error occurd : "+e;

		}
		
		return "done";

	}

}