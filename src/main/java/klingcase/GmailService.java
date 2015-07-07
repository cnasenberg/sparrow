package klingcase;

import org.springframework.stereotype.Service;

@Service
public class GmailService implements EmailService {

      public void sendEmail(String emailAddress, String subject, String body) {
		System.out.println("... Sending email to "+emailAddress+"... ");
		// send email via gmail account  
      }

}