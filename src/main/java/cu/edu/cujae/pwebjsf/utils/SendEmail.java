package cu.edu.cujae.pwebjsf.utils;

import cu.edu.cujae.pwebjsf.config.GlobalConfig;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendEmail {

  @Autowired
  GlobalConfig globalConfig;

  public void sendEmail(
    String email,
    String name,
    String subject,
    String randomPIN
  ) throws AddressException, MessagingException, IOException {
    Properties props = new Properties();
    props.put("mail.smtp.auth", globalConfig.getEmail_auth());
    props.put("mail.smtp.starttls.enable", globalConfig.getEmail_starttls());
    props.put("mail.smtp.host", globalConfig.getEmail_host());
    props.put("mail.smtp.port", globalConfig.getEmail_port());
    props.put("mail.smtp.ssl.trust", globalConfig.getEmail_host());

    Session session = Session.getInstance(
      props,
      new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(
            globalConfig.getEmail_username(),
            globalConfig.getEmail_password()
          );
        }
      }
    );
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(globalConfig.getEmail_username(), false));

    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
    msg.setSubject(subject);
    msg.setContent(subject, "text/html");
    msg.setSentDate(new Date());

    String htmlMsg =
      "<h3>Hola, " +
      name +
      "</h3><p>Aquí está su código de recuperación de contraseña:</p><br><p><b>" +
      " " +
      randomPIN +
      " " +
      "</b></p><br><p>Si no solicitó una recuperación de contraseña, puede ignorar este correo electrónico. " +
      " </p><br><p>Si tiene alguna pregunta, no dude en contactarnos en: " +
      " </p><p> <a href='mailto: " +
      globalConfig.getEmail_username() +
      "'>" +
      globalConfig.getEmail_username() +
      "</a>" +
      "</p><br><p>Saludos,<br>CarRent Team</p>";

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(htmlMsg, "text/html");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);

    msg.setContent(multipart);
    Transport.send(msg);
  }
}
