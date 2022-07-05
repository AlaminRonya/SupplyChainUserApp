package com.alamin_tanveer.supplychain.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender {
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void send(String name, String toEmail) {
            SimpleMailMessage message = new SimpleMailMessage();
            String mail = String.format("""
                    Hi, %s
                    Congratulations. You have registered successfully.
                    """, name);

            message.setFrom("spring.email.from@gmail.com");
            message.setTo(toEmail);
            message.setText(mail);
            message.setSubject("Registration Successful for Dealer's");

            mailSender.send(message);
    }
}
