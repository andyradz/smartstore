package com.codigo.smartstore.webapi.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("EmailService")
public class EmailService
	implements IEmailService {

	private static final String NOREPLY_ADDRESS = "noreply@baeldung.com";

	@Inject
	private JavaMailSender emailSender;

	@Inject
	private SimpleMailMessage template;

	// @Value("classpath:/mail-logo.png")
	// private Resource resourceFile;

	@Override
	public void sendSimpleMessage(final String to, final String subject, final String text) {

		try {

			final SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(NOREPLY_ADDRESS);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);

			this.emailSender.send(message);
		} catch (final MailException exception) {

			exception.printStackTrace();
		}
	}

	@Override
	public void sendSimpleMessageUsingTemplate(final String to, final String subject, final String... templateModel) {

		final String text = String.format("%s %s", this.template.getText(), templateModel);
		this.sendSimpleMessage(to, subject, text);
	}

	@Override
	public void sendMessageWithAttachment(final String to, final String subject, final String text,
			final String pathToAttachment) {

		try {

			final MimeMessage message = this.emailSender.createMimeMessage();
			// pass 'true' to the constructor to create a multipart message
			final MimeMessageHelper helper = new MimeMessageHelper(
					message, true);

			helper.setFrom(NOREPLY_ADDRESS);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);

			final FileSystemResource file = new FileSystemResource(
					new File(
							pathToAttachment));
			helper.addAttachment("Invoice", file);

			this.emailSender.send(message);
		} catch (final MessagingException e) {

			e.printStackTrace();
		}
	}

	private void sendHtmlMessage(final String to, final String subject, final String htmlBody)
			throws MessagingException {

		final MimeMessage message = this.emailSender.createMimeMessage();
		final MimeMessageHelper helper = new MimeMessageHelper(
				message, true, "UTF-8");
		helper.setFrom(NOREPLY_ADDRESS);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(htmlBody, true);
		// helper.addInline("attachment.png", this.resourceFile);
		this.emailSender.send(message);
	}

	@Override
	public void sendMessageUsingThymeleafTemplate(final String to, final String subject,
			final Map<String, Object> templateModel) throws IOException, MessagingException {

		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessageUsingFreemarkerTemplate(final String to, final String subject,
			final Map<String, Object> templateModel) throws IOException, MessagingException {

		// TODO Auto-generated method stub

	}

}
