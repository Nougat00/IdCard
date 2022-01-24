package com.example.IdCard.messeges;

import com.example.IdCard.model.EmailValues;
import com.example.IdCard.model.OneCard;
import com.example.IdCard.services.IdCardServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
public class MessageSender {


    public void send(EmailValues emailValues) {

        String from = "idcardfrom@gmail.com";
        String host = "smtp.gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.ssl.trust", "*");


        Session session = Session.getInstance(prop, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("idcardfrom", "s23046@pjwstk");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailValues.getTo()));
            message.setSubject("IdCard - " + emailValues.getName() + " " + emailValues.getSurname());
            message.setText("Your id card:\n"
                    + emailValues.getName() + "\n"
                    + emailValues.getSurname() + "\n"
                    + emailValues.getPhone() + "\n"
                    + emailValues.getBirthday());
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}

