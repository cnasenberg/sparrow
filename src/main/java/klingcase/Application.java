package klingcase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application {

	@Bean
    UserService userService() {
		// create depending on configuration
		return new SimpleUserService();
	}
	
    EmailService emailService() { 
		// create depending on configuration
		return new GmailService();
    }

	public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
	  UserService userService = context.getBean(UserService.class);
	  EmailService emailService = context.getBean(EmailService.class);
	  userService.setEmailService(emailService);
	
	  String name = args[0];
	  String emailAddress = args[1];
	  userService.createUser(name, emailAddress);
  }
}