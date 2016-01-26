package eu.nasenberg.sparrow.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import eu.nasenberg.sparrow.entity.User;

import org.junit.Before;

public class UserTest {
		
    private String nameInput;
    private String emailAddressInput;
    private User testUser;
    
    @Before
    public void setUp() {
        nameInput = "Sparrow";
        emailAddressInput = "sparrow@hawk.nest";
    }
    
    @Test
	public void testSetEmailAddress() {
        testUser = new User(nameInput);
		testUser.setEmailAddress(emailAddressInput); 
        String emailAddressOutput = testUser.getEmailAddress();
        assertEquals(emailAddressInput, emailAddressOutput);
	}
    
    @Test
    public void testGetCorrectUsername() {
        testUser = new User(nameInput, emailAddressInput);
        String nameOutput = testUser.getUsername();
        assertEquals(nameInput, nameOutput);
    }
    
    @Test
    public void testGetCorrectEmailAddress() {
        testUser = new User(nameInput, emailAddressInput);
        String emailAddressOutput = testUser.getEmailAddress();
        assertEquals(emailAddressInput, emailAddressOutput);
    }
    
    @Test
    public void testGetCorrectId() {
        testUser = new User(nameInput, emailAddressInput);
        long idInput = 123456;
        testUser.setId(idInput);
        long idOutput = testUser.getId();
        assertEquals(idInput, idOutput);
    }
}