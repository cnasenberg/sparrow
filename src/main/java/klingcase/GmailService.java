package klingcase;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@Service
public class GmailService implements EmailService {

	private MailSender mailSender;

	@Autowired
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendEmail(String emailAddress, String subject, String body) throws MailException {

		System.out.println("... Sending email to " + emailAddress + "... ");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailAddress);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);

	}

}