package klingcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private EmailService emailService;
	private UserDAO userDAO;

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void createUser(String username, String emailAddress) {

		try {
			userDAO.save(new User(username, emailAddress));
			System.out.println("New user " + username + " has been created.");

			try {
				emailService.sendEmail(emailAddress, "The Damn Email. ;)", "Dear " + username
						+ ", \nYour account has been created. " + "\nThank you for supporting this project! ");
				System.out.println("Account details have been sent to " + emailAddress + ". ");
				
			} catch (Exception e) {
				e.printStackTrace(System.err);
				System.out.println("Email was not sent out, please contact support@nasenberg.com.");
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
			System.out.println("Your user account was not created, please contact support@nasenberg.com.");
		}

	}

}