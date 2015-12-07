package sparrow;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest {
		
	@Test
	public void testGetCorrectUsername() {
		String nameInput = "Sparrow";
		String emailAddressInput = "sparrow@hawk.nest"; 
		User testUser = new User(nameInput, emailAddressInput);
		String nameOutput = testUser.getUsername();
		assertEquals(nameInput, nameOutput);
	}
 
}