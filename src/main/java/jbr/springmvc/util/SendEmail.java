package jbr.springmvc.util;

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

	public static void sendmail(String email, String code) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("te4637495@gmail.com", "Wyn8wn4GcCnX3pV");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("te4637495@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Verify Email");
		msg.setContent("Your verification Code is :" + code, "text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Your verification Code is :" + code, "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		Transport.send(msg);
	}
}
