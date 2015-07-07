package klingcase;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmail(String emailAddress, String subject, String body);
}