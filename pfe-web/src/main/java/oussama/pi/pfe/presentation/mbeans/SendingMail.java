package oussama.pi.pfe.presentation.mbeans;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingMail {
    
    public static  String mailUsername ;
      public static  String mailPassword;
      public static String contenu ;
      public static String destination ;
      public static String subject ;
  public SendingMail(String contenu,String destination , String subject) {
      mailUsername = "walid.nsiri@hotmail.com";
      mailPassword = "Fm12345678";
      this.contenu=contenu ;
      this.destination=destination ;
      this.subject=subject ;
  }
      
      
public static void envoyer () {
      Properties props = new Properties();
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.host", "smtp.live.com");
      props.put("mail.smtp.port", "25");

      Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication("walid.nsiri@hotmail.com", "Fm12345678");
          }
        });

      try {

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("walid.nsiri@hotmail.com"));
          message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse(destination));
          message.setSubject(subject);
          message.setText(contenu);

          Transport.send(message);

          System.out.println("Done");

      } catch (MessagingException e) {
          throw new RuntimeException(e);
      }
  
}

}
