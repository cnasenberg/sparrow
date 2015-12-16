package sparrow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@RunWith(MockitoJUnitRunner.class)
public class JdbcUserDAOTest {
    
    private String username;
    private String emailAddress;
    private User testUser;
    private long generatedId;
    
	@Autowired
	@InjectMocks  
    private JdbcUserDAO testJdbcUserDAO;
	
    @Mock
    private JdbcTemplate mockJdbcTemplate;
            
    @Mock
    private SimpleJdbcInsert userInsert;
    
    @Before
    public void setUp() {
		
        username = "Blackbird";
        emailAddress = "black@bird.tree";
        testUser = new User(username, emailAddress);
        generatedId = 7;
        
        when(userInsert.withTableName(any(String.class))).thenReturn(userInsert);
        
        when(userInsert.usingColumns(any(String.class), any(String.class))).thenReturn(userInsert);
        
        when(userInsert.executeAndReturnKey(any(Map.class))).thenReturn(generatedId);
    }    
	
	@Test
	public void verifyServiceInjection() {
		assertNotNull(userInsert);
	}
    
	@Test
    public void testSaveUserReturnsUser() {
		User savedUser = testJdbcUserDAO.save(testUser);
        assertNotNull(savedUser);
    }
	
	@Test
    public void testSaveUserReturnsSameUserObject() {
		User savedUser = testJdbcUserDAO.save(testUser);
        assertSame(savedUser, testUser);
    }
    
    @Test
    public void testSaveUserReturnsUserWithID() {
    	assertEquals(0, testUser.getId());
        User savedUser = testJdbcUserDAO.save(testUser);
        assertEquals(savedUser.getId(), generatedId);
    }
}