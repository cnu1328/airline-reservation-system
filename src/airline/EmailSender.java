package airline;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.Session;



public class EmailSender {

    public static void sendEmail(String recipientEmail, String subject, String messageBody) {
        // Sender's email credentials
        String senderEmail = "cnu44345@gmail.com";
        String senderPassword = "(nu).().()";

        // SMTP server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Create a MimeMessage object
            Message message = new MimeMessage(session);
            // Set From: header
            message.setFrom(new InternetAddress(senderEmail));
            // Set To: header
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            // Set Subject: header
            message.setSubject(subject);
            // Set message body
            message.setText(messageBody);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to " + recipientEmail);
        } catch (MessagingException e) {
            System.out.println("Email failed to send. Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage
        String recipientEmail = "cnu444345@gmail.com";
        String subject = "Welcome aboard!";
        String messageBody = "Dear Passenger, welcome aboard our flight!";

        sendEmail(recipientEmail, subject, messageBody);
    }
}

