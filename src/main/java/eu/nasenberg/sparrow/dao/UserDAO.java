package eu.nasenberg.sparrow.dao;

import eu.nasenberg.sparrow.entity.User;
 
public interface UserDAO {
	public User save(User user);
	public User get(User user);
}