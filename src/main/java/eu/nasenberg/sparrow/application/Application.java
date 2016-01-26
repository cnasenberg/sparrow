package eu.nasenberg.sparrow.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import eu.nasenberg.sparrow.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.io.IOException;

public class Application {
    
    final static Logger logger = LoggerFactory.getLogger(Application.class);
    
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        logger.info("Entering application.");
        
		Console console = System.console();
        if (console == null) {
            logger.error("No console.");
            System.exit(1);
        }
        
        String name = console.readLine("Please enter your name: ");
        String emailAddress = console.readLine("Please enter your email address: ");
        
        logger.info(String.format("User %s entered email address: %s", name, emailAddress));

        UserService userService = context.getBean(UserService.class);
		userService.createUser(name, emailAddress);		
		
        logger.info("Exiting application.");
	}
}