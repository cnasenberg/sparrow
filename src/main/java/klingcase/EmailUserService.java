package klingcase;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleUserService implements UserService {

	private EmailService emailService;
	
	@Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

	public void createUser(String username, String emailAddress) {
		User user = new User(username, emailAddress); 
		
		// store user data in database  
		System.out.println("New user "+username+" has been created.");
		
		// send account email 
		this.emailService.sendEmail(emailAddress, "Your New Klingcase Account", "Dear "+username+", \nYour Klingcase account has been created.");
		System.out.println("Account details have been sent to "+emailAddress+". ");
     }

}