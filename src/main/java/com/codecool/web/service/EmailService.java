package com.codecool.web.service;

import com.codecool.web.model.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {

    public void sendEmail(User user) {
        final String username = "CodeCoolLMS@gmail.com";
        final String password = "Ahd373821";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("CodeCoolLMS@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(user.getEmail()));
            message.setSubject("Codecool LMS registration");
            message.setText("Dear " + user.getName() + ","
                + "\n\nYou have successfully qualified to next round of Dick Sword Championship 2019!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

}
