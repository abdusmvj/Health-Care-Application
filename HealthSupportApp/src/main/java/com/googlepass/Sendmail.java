package com.googlepass;


	
	
	// Java program to send email
	// with HTML templates

	import java.util.*;
	import javax.mail.*;
	import javax.mail.internet.*;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.activation.*; 


	public class Sendmail
	{

	public static void main(String [] args)
	{
		 System.out.println("SimpleEmail Start");
		 final String SMTP_SERVER = "localhost";
		    final String SMTP_PORT = "135";
		    final String TO_EMAIL = "abdus.mvj@gmail.com";
		    final String TO_EMAIL1 = "dumidu@thal.com";
		    final String FROM_EMAIL = "abdus7001.pcs@gmail.com";
		    final String FROM_EMAIL_PASSWORD = "1234";
			
		    String smtpHostServer = "localhost";
		    String emailID = "abdus.mvj@gmail.com";
		    Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session mailSession = Session.getInstance(props, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, FROM_EMAIL_PASSWORD);
                }
            });
			

			try {  
			     MimeMessage message = new MimeMessage(mailSession);  
			     message.setFrom(new InternetAddress(FROM_EMAIL));  
			     message.addRecipient(Message.RecipientType.TO,new InternetAddress(TO_EMAIL));  
			     message.setSubject("Test mail");  
			     message.setText("This is simple program of sending email using JavaMail API");  
			       
			    //send the message  
			     Transport.send(message);  
			  
			     System.out.println("message sent successfully...");  
			   
			     } catch (MessagingException e) {e.printStackTrace();}  
	}
	
	

	
		public static void sendEmail(Session session, String toEmail, String subject, String body){
			try
		    {
		      MimeMessage msg = new MimeMessage(session);
		      //set message headers
		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");

		      msg.setFrom(new InternetAddress("abdus7001.pcs@gmail.com", "NoReply-JD"));

		      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

		      msg.setSubject(subject, "UTF-8");

		      msg.setText(body, "UTF-8");
		     

		      msg.setSentDate(new Date());

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		      System.out.println("Message is ready");
	    	  Transport.send(msg);  

		      System.out.println("EMail Sent Successfully!!");
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		}
	
	

	
}