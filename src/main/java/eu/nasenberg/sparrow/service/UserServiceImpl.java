package eu.nasenberg.sparrow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.nasenberg.sparrow.application.Application;
import eu.nasenberg.sparrow.dao.UserDAO;
import eu.nasenberg.sparrow.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
	private EmailService emailService;
    
    @Autowired
	private UserDAO userDAO;
    
    final static Logger logger = LoggerFactory.getLogger(Application.class);

	public User createUser(String username, String emailAddress) {
        
        User newUser = null;
        String emailSentTo = "";
        
		try {            
			newUser = userDAO.save(new User(username, emailAddress));
			logger.info("User data for " + newUser.getUsername() + " has been saved.");
			
			System.out.println("Thank you " + newUser.getUsername() + ", your account has been created.");
			logger.info("New user " + newUser.getUsername() + " with email address " + newUser.getEmailAddress() + " and ID " + newUser.getId() + " has been created.");

			try {
				emailSentTo = emailService.sendEmail(newUser.getEmailAddress(), "Your User Account", "Dear " + newUser.getUsername() + ", \nYour account has been created. " + "\nThank you for supporting this project! ");
				System.out.println("Account details have been sent to " + emailSentTo + ". ");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				System.out.println("Your account was created, but the email was not sent out. Please check your email configuration.");
			}
		} catch (Exception e) {
            logger.error(e.getMessage(), e);
			System.out.println("Your user account was not created, your data could not be stored. Please contact support@nasenberg.eu.");
		}
        
        return newUser;
	}

}