package sparrow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.io.Console;
import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		Console console = System.console();
        if (console == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String name = console.readLine("Please enter your name: ");
        String emailAddress = console.readLine("Please enter your email address: ");

        UserService userService = context.getBean(UserService.class);
		userService.createUser(name, emailAddress);		
		
	}
}