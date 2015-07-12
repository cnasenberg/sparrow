package klingcase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import java.io.Console;
import java.io.IOException;

@Configuration
@ComponentScan
public class Application {

    UserService userService() {
		// create depending on configuration
		return new UserServiceImpl();
	}
	
    EmailService emailService() { 
		// create depending on configuration
		return new GmailService();
    }

	public static void main(String[] args) throws IOException {

		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		UserService userService = context.getBean(UserService.class);
		
		Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String name = console.readLine("Please enter your name: ");
        String emailAddress = console.readLine("Please enter your email address: ");
		userService.createUser(name, emailAddress);
	}
}