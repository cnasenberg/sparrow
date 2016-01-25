package eu.nasenberg.sparrow;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mail.MailSender;

import eu.nasenberg.sparrow.EmailServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceImplTest {
	
	@InjectMocks
	private EmailServiceImpl emailService;

	@Mock 
	private MailSender mailSender;
	
    private String emailAddress;
    private String subject;
    private String body;
	
	@Before
	public void setUp() throws Exception {
        emailAddress = "blue@bird.tree";
        subject = "Test Subject";
        body = "Test email body.";
	}

	@Test
	public void testMessageIsCreatedCorrectly() {
		String sentTo = emailService.sendEmail(emailAddress, subject, body);
		assertEquals(emailAddress, sentTo);
	}

}
