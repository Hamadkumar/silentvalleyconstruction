package com.silent.valley.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.silent.valley.entity.ContactRequest;
import com.silent.valley.entity.Mail;
import com.silent.valley.entity.QuotationRequest;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	ApplicationContext context;

	public void sendQuotation(QuotationRequest quotationRequest) {
		Mail mail = new Mail();
		mail.setMailFrom("silentvalleyconstruction@gmail.com");
		mail.setMailTo("silentvalleyconstruction@gmail.com");
		mail.setMailSubject("Quotation request - " + quotationRequest.getFirstName() + quotationRequest.getLastName());
		mail.setMailContent("Hello Sir/Mam,\n\nThe following user is seeking a quotation request. Kindly look into it."
				+"\n\nName - " + quotationRequest.getFirstName() + quotationRequest.getLastName()
				+"\nPhone Number - " + quotationRequest.getPhoneNumber()
				+"\nService Name - " + quotationRequest.getServiceName()
				+"\nMessage - " + quotationRequest.getMessageContent()
				+"\n\nThanks,"
				+ "\nwww.silentvalleyconstruction.com");
		this.sendEmail(mail);
	}

	public void sendContact(ContactRequest contactRequest) {
		Mail mail = new Mail();
		mail.setMailFrom("silentvalleyconstruction@gmail.com");
		mail.setMailTo("silentvalleyconstruction@gmail.com");
		mail.setMailSubject("Contact request - " + contactRequest.getName());
		mail.setMailContent("Hello Sir/Mam,\n\nThe following user is trying to contact you. Kindly look into it."
				+"\n\nName - " + contactRequest.getName()
				+"\nPhone Number - " + contactRequest.getPhoneNumber()
				+"\nEmail ID - " + contactRequest.getEmailId()
				+"\nSubject - " + contactRequest.getSubject()
				+"\nMessage - " + contactRequest.getMessageContent()
				+"\n\nThanks,"
				+ "\nwww.silentvalleyconstruction.com");
		this.sendEmail(mail);
	}

	private void sendEmail(Mail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "Silent Valley Construction"));
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setText(mail.getMailContent());
			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
