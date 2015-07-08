package klingcase;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	void createUser(String username, String emailAddress);
}