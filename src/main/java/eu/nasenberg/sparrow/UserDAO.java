package eu.nasenberg.sparrow;

import eu.nasenberg.sparrow.User;
 
public interface UserDAO {
	public User save(User user);
	public User get(User user);
}