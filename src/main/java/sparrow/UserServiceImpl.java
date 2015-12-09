package sparrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
	private EmailService emailService;
    
    @Autowired
	private UserDAO userDAO;
    
    final static Logger logger = LoggerFactory.getLogger(Application.class);

	public void createUser(String username, String emailAddress) {
        
		try {
			userDAO.save(new User(username, emailAddress));
			System.out.println("New user " + username + " has been created.");

			try {
				emailService.sendEmail(emailAddress, "Your User Account", "Dear " + username
						+ ", \nYour account has been created. " + "\nThank you for supporting this project! ");
				System.out.println("Account details have been sent to " + emailAddress + ". ");
				
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				System.out.println("Email was not sent out, please contact support@nasenberg.com.");
			}
		} catch (Exception e) {
            logger.error(e.getMessage(), e);
			System.out.println("Your user account was not created, please contact support@nasenberg.com.");
		}

	}

}