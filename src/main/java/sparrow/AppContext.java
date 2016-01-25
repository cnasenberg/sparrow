package sparrow;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@Configuration 
@ImportResource("config.xml")
public class AppContext {
	
}
