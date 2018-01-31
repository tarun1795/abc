package com.accolite.sleeppods.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MailUtility {

	private static final Logger logger = Logger.getLogger(MailUtility.class);

	@Autowired
	JavaMailSender mailSender;

	@Async
	public void sendEmailAsync(String to, String subject, String text) {
		logger.info("Sending mail to " + to + " SUBJECT: " + subject);
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(to);
		email.setSubject(subject);
		email.setText(text);
		try {
			
			mailSender.send(email);
		} catch (MailException e) {
			logger.error("Error sending email",e);
		}
	}
}