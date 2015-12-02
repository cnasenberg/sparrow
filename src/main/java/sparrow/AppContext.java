package sparrow;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.mail.MailSender;

@ComponentScan
@Configuration 
@ImportResource("config.xml")
public class AppContext {
	
	@Autowired DataSource dataSource; // from @ImportResource   
	@Autowired MailSender mailSender; 
}
