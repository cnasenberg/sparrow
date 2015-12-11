package sparrow;

public interface EmailService {
    String sendEmail(String emailAddress, String subject, String body);
}