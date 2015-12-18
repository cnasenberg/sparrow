package sparrow;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailServiceImpl implements EmailService {
    
    final static Logger logger = LoggerFactory.getLogger(EmailService.class);

	@Autowired private MailSender mailSender;
	
	private SimpleMailMessage message;

	public String sendEmail(String emailAddress, String subject, String body) throws MailException {

        logger.info("... Sending email to " + emailAddress + "... ");
		
		message = new SimpleMailMessage();
		message.setTo(emailAddress);
		message.setSubject(subject);
		message.setText(body);

		mailSender.send(message);
		String sentTo = message.getTo()[0];
		
        logger.info("Email was sent to " + sentTo);
        return sentTo;
	}

}