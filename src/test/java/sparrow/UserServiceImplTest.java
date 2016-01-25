package sparrow;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    
    private String username;
    private String emailAddress;
    private long id;
    
    @Mock UserDAO mockUserDAO;
    
    @Mock EmailService mockEmailService;
    
    @Mock User mockNewUser;
    
    @InjectMocks UserService testUserService = new UserServiceImpl();

    @Before
    public void setUp() {

        when(mockUserDAO.save(any(User.class))).thenReturn(mockNewUser);
    	
    	username = "Blackbird";
        emailAddress = "black@bird.tree";
        id = 1;
        
        when(mockNewUser.getUsername()).thenReturn(username);
        when(mockNewUser.getEmailAddress()).thenReturn(emailAddress);
        when(mockNewUser.getId()).thenReturn(id);
        
        when(mockEmailService.sendEmail(any(String.class), any(String.class), any(String.class))).thenReturn(emailAddress);
    }
    
	@Test
    public void testCreateUserReturnsAUser() {
        User user = testUserService.createUser(username, emailAddress);
        assertNotNull(user);
    }
    
    @Test
    public void testCreateUserReturnsCorrectUserObject() {
        User user = testUserService.createUser(username, emailAddress);
        assertEquals(user.getUsername(), username);
        assertEquals(user.getEmailAddress(), emailAddress);
        assertNotNull(user.getId());
    }

}