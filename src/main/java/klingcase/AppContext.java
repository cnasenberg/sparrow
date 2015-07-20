package klingcase;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.mail.MailSender;

@ComponentScan
@Configuration 
@ImportResource("config.xml")
public class AppContext {
	
    @Inject DataSource dataSource; // from @ImportResource   
    @Inject MailSender mailSender; 
}
