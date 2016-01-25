package eu.nasenberg.sparrow;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class AppContextTest {
	
	private AnnotationConfigApplicationContext context;
	
	@Autowired private DataSource dataSource;
	@Autowired private JavaMailSenderImpl mailSender;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private SimpleJdbcInsert userInsert;
	
	@Before 
	public void setUp() {
		context = new AnnotationConfigApplicationContext();	
		context.scan("eu.nasenberg.sparrow"); // Scans for available configurations.
		context.refresh();
	}
	
	@Test
	public void testContextAvailable() {
		assertNotNull(context);
	}
	
	@Test
	public void testBeansAvailable() {
		assertNotNull(context.getBean(DataSource.class));
		assertNotNull(context.getBean(LocalSessionFactoryBean.class));		
		assertNotNull(context.getBean(JavaMailSenderImpl.class));
	}
	
	@Test @Ignore
	public void testBeansAutowired() {
		assertNotNull(jdbcTemplate);
		assertNotNull(userInsert);
		assertNotNull(dataSource);
		assertNotNull(mailSender);
	}
}
