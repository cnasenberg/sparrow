package klingcase;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.context.annotation.*;

@ComponentScan
@Configuration 
@ImportResource("config.xml")
public class AppContext {
	
    @Inject DataSource dataSource; // from @ImportResource   

}
