package org.example.service;


import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class EmailService {

    @Value("${sendgrid.api-key}")
    private String sendGridApiKey;

    @Value("${sendgrid.from-email}")
    private String fromEmail;

    @Value("${sendgrid.from-name}")
    private String fromName;

    // Add this method to test
    @PostConstruct
    public void init() {
        System.out.println("=== SendGrid Config ===");
        System.out.println("API Key: " + (sendGridApiKey != null ? sendGridApiKey.substring(0, 10) + "..." : "NULL"));
        System.out.println("From Email: " + fromEmail);
        System.out.println("From Name: " + fromName);
        System.out.println("====================");
    }

    public void sendOrderConfirmation(String toEmail, String orderDetails) {
        Email from = new Email(fromEmail, fromName);
        Email to = new Email(toEmail);
        String subject = "Order Confirmation";
        Content content = new Content("text/html", orderDetails);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            System.out.println("Email sent! Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
        } catch (IOException ex) {
            throw new RuntimeException("Failed to send email", ex);
        }
    }
}