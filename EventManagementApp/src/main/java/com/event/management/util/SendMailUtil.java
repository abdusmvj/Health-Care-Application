package com.event.management.util;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

public class SendMailUtil {

	
	Properties prop = new Properties();
	String resourceName = "common.properties"; 
	String username=null;
	String password=null;
	String smtpHost=null;
	
	public  boolean mail(String emailId,String msgbody,String mailSubject,HttpServletRequest req) {

		boolean isMailSent=false;
		
		prop=CommonUtility.loadPropertyFile(resourceName);
		username=prop.getProperty("mail.username");
		password=prop.getProperty("mail.password");
		smtpHost=prop.getProperty("mail.smtp.host");
		

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "*"); 

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(emailId));
			message.setSubject(mailSubject);
			
			MimeMultipart multipart = new MimeMultipart(); 
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setText(msgbody);
			bodyPart.setContent(msgbody,"text/html");
			multipart.addBodyPart(bodyPart);
			message.setContent(multipart);
			Transport.send(message);

			System.out.println("Done");
			isMailSent=true;
		} catch (MessagingException e) {
			isMailSent=false;
			throw new RuntimeException(e);
		}
		
		return isMailSent;
	}
	
	
}
