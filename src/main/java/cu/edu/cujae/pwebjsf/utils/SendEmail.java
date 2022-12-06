package cu.edu.cujae.pwebjsf.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

  public void sendEmail(String email, String name, String subject, String randomPIN)
    throws AddressException, MessagingException, IOException {
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(
      props,
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(
            "pweb.carrent.2022@gmail.com",
            "mmaxunljgjvyjmww"
          );
        }
      }
    );
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress("pweb.carrent.2022@gmail.com", false));

    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
    msg.setSubject(subject);
    msg.setContent(subject, "text/html");
    msg.setSentDate(new Date());

    String htmlMsg =
      "<h3>Hola, " +
      name +
      "</h3><p>Aquí está su código de recuperación de contraseña: " +
      randomPIN +
      "</p><br><p>Saludos,<br>CarRent Team</p>";

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(htmlMsg, "text/html");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);

    msg.setContent(multipart);
    Transport.send(msg);
  }
}
