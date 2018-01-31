package com.accolite.sleeppods.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.accolite.sleeppods.util.MailUtility;
import com.accolite.sleeppods.util.UriUtility;

@Configuration
public class UtilityBeans {

	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("my.gmail@gmail.com");
		mailSender.setPassword("password");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Bean
	public MailUtility mailUtil() {
		return new MailUtility();
	}

	@Bean
	public UriUtility uriUtil() {
		return new UriUtility();
	}
}
