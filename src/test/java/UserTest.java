package sparrow;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class UserTest {
		
    private String nameInput;
    private String emailAddressInput;
    private User testUser;
    
    @Before
    public void setUp() {
        nameInput = "Sparrow";
        emailAddressInput = "sparrow@hawk.nest";
        testUser = new User(nameInput, emailAddressInput);
    }
    
    @Test
    public void testGetCorrectUsername() {
        String nameOutput = testUser.getUsername();
        assertEquals(nameInput, nameOutput);
    }
    
    @Test
    public void testGetCorrectEmailAddress() {
        String emailAddressOutput = testUser.getEmailAddress();
        assertEquals(emailAddressInput, emailAddressOutput);
    }
    
    @Test
    public void testGetCorrectId() {
        long idInput = 123456;
        testUser.setId(idInput);
        long idOutput = testUser.getId();
        assertEquals(idInput, idOutput);
    }
}