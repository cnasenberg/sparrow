package sparrow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.io.IOException;

public class Application {
    
    final static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        
        logger.info("Entering application.");

        String name = console.readLine("Please enter your name: ");
        String emailAddress = console.readLine("Please enter your email address: ");

        UserService userService = context.getBean(UserService.class);
		userService.createUser(name, emailAddress);		
		
        logger.info("Exiting application.");
	}
}