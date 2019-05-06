package test;

import javafx.fxml.FXML;

import javafx.scene.text.Text;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvoyerEmailController {
	@FXML
	private Text lblRudyCom;
	@FXML
	private Label lblClose;
	@FXML
	private TextArea textArea;
	@FXML
	private TextField textfield;
	@FXML
	private Button Send;

	// Event Listener on Button[#Send].onAction
	@FXML
	public void sendEmail(ActionEvent event) {
		
		String msg=textfield.getText();
		  Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
	                

			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("raniamnissi1995","rania1234");
					}
				});
			try {
			String u="rania.mnissi@esprit.tn";
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(u));
			message.setSubject("Reservation");
			message.setText(msg);

			Transport.send(message);

			System.out.println("Done");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	                
	}
}
