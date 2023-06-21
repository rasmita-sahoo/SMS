package com.Email.Service;

import com.Email.Entity.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getRecipientEmail());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getContent());
        mailSender.send(message);
    }

    // Other service methods for email operations
    // ...

}
