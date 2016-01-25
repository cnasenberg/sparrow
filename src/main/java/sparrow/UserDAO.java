package sparrow;

import sparrow.User;
 
public interface UserDAO {
	public User save(User user);
	public User get(User user);
}