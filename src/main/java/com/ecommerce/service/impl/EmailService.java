package com.ecommerce.service.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	public static void sendEmail(String message, String to) {
		String subject="Muskan Shopping -reset  your password ";
		String from="muskanshopsupport@gmail.com";
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session =Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return  new PasswordAuthentication("testsoftware553@gmail.com","nlznzrjunldxdzhn");
			}
			
		
		});
		session.setDebug(true);
		
		MimeMessage compose=new MimeMessage(session);
		
		try {
			compose.setFrom(from);
			compose.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			compose.setSubject(subject);
			compose.setText(message);
			Transport.send(compose);
			System.out.println("message sent succesfully");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}