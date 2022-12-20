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
public class EmailUtils {

  @Autowired
  GlobalConfig globalConfig;

  public void sendEmail(String email, String subject, String htmlMsg)
    throws AddressException, MessagingException, IOException {
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

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(htmlMsg, "text/html");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);

    msg.setContent(multipart);
    Transport.send(msg);
  }
}
