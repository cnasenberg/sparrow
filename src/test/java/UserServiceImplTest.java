package sparrow;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    
    @Mock UserDAO userDAOMock;
    
    @Mock EmailService emailServiceMock;
    
    @InjectMocks UserService testUserService = new UserServiceImpl();

	@Test
    public void testCreateUser() {
        testUserService.createUser("TestName", "test@email.address");
    }

}