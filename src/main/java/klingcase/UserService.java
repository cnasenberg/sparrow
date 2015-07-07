package klingcase;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	void setEmailService(EmailService emailService);
	void createUser(String username, String emailAddress);
}