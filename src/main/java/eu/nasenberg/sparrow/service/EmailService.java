package eu.nasenberg.sparrow.service;

public interface EmailService {
	
	/**
	 * Sends out an email constructed of a subject and a body to a given email address. 
	 * 
	 * @param emailAddress	the target email address 
	 * @param subject		the email's subject 
	 * @param body			the email's body 
	 * @return the email address to which the email has been sent successfully. 
	 */
    String sendEmail(String emailAddress, String subject, String body);
}