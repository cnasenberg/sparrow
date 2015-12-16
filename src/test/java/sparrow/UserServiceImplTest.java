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
    
    @Mock UserDAO mockUserDAO;
    
    @Mock EmailService mockEmailService;
    
    @Mock User mockNewUser;
    
    @InjectMocks UserService testUserService = new UserServiceImpl();

    @Before
    public void setUp() {
        username = "Blackbird";
        emailAddress = "black@bird.tree";
        
        when(mockUserDAO.save(any(User.class))).thenReturn(mockNewUser);
        when(mockEmailService.sendEmail(any(String.class), any(String.class), any(String.class))).thenReturn(emailAddress);
        when(mockNewUser.getUsername()).thenReturn(username);
    }
    
	@Test
    public void testCreateUserReturnsAUser() {
        User newUser = testUserService.createUser(username, emailAddress);
        assertNotNull(newUser);
    }
    
    @Test
    public void testCreateUserReturnsCorrectUserObject() {
        User newUser = testUserService.createUser(username, emailAddress);
        assertSame(newUser, mockNewUser);
    }

}