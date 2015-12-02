package sparrow;

public interface EmailService {
    void sendEmail(String emailAddress, String subject, String body);
}