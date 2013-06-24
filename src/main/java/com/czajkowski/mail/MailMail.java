package com.czajkowski.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailMail
{
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	
	public void sendMail(String dear, String content) {

		SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
		
		message.setText(String.format(
				simpleMailMessage.getText(), dear, content));

		mailSender.send(message);
	}
		
}
