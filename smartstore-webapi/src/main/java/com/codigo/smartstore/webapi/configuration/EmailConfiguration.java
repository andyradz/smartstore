package com.codigo.smartstore.webapi.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(
	basePackages = {
		"com.codigo.smartstore" })
public class EmailConfiguration {

	@Bean
	public JavaMailSenderImpl getJavaMailSender() {

		final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("my.gmail@gmail.com");
		mailSender.setPassword("password");

		final Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Bean
	public SimpleMailMessage templateSimpleMessage() {

		final SimpleMailMessage message = new SimpleMailMessage();
		message.setText("This is the test email template for your email:\n%s\n");
		return message;
	}

	// @Bean
	// public ResourceBundleMessageSource emailMessageSource() {
	//
	// final ResourceBundleMessageSource messageSource = new
	// ResourceBundleMessageSource();
	// messageSource.setBasename("/mailMessages");
	// return messageSource;
	// }

}
