package eu.nasenberg.sparrow.service;

import eu.nasenberg.sparrow.entity.User;

public interface UserService {
	User createUser(String username, String emailAddress);
}