package sparrow;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GmailService implements EmailService {
    
    final static Logger logger = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private MailSender mailSender;

	public String sendEmail(String emailAddress, String subject, String body) throws MailException {

        logger.info("... Sending email to " + emailAddress + "... ");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailAddress);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);
        
        logger.info("Email has been sent to " + emailAddress);
        return emailAddress;
	}

}