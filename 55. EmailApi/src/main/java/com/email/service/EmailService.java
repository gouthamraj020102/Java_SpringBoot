package com.email.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // This method is responsible to send Email...
    public boolean sendEmail(String subject, String message, String to) {

        boolean boo = false;
        String from = "testing94915@gmail.com";
        // variable for gmail
        String host = "smtp.gmail.com";

        // get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES is = " + properties);

        // setting important information to the properties object
        // host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Step 1: to get the session object...
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testing94915@gmail.com", "ljjivyooazauojre");
            }
        });
        session.setDebug(true);

        // Step 2: Compose the message [text, multi-media]
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            // from email
            mimeMessage.setFrom(from);
            // adding recipient to message
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // adding subject to message
            mimeMessage.setSubject(subject);
            // adding text to message
            mimeMessage.setText(message);

            // Step 3: Send the message using Transport class
            Transport.send(mimeMessage);
            System.out.println("Sent success.....");
            boo = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return boo;
    }

    // This method is responsible to send the message with attachment...
    public static void sendAttach(String message, String subject, String to, String from) {

        // variable for gmail
        String host = "smtp.gmail.com";

        // get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES is = " + properties);

        // setting important information to the properties object
        // host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Step 1: to get the session object...
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testing94915@gmail.com", "ljjivyooazauojre");
            }
        });
        session.setDebug(true);

        // Step 2: Compose the message [text, multi-media]
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            // from email
            mimeMessage.setFrom(from);
            // adding recipient to message
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // adding subject to message
            mimeMessage.setSubject(subject);
            // attachment...
            // file path
            String path = "C:\\Users\\Gowtham Raju\\Downloads\\1468864.jpg";
            MimeMultipart mimeMultipart = new MimeMultipart();
            // text
            // file
            MimeBodyPart textMime = new MimeBodyPart();
            MimeBodyPart fileMime = new MimeBodyPart();
            try {
                textMime.setText(message);
                File file = new File(path);
                fileMime.attachFile(file);
                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(fileMime);
            } catch (Exception e) {
                e.printStackTrace();
            }

            mimeMessage.setContent(mimeMultipart);

            // Step 3: Send the message using Transport class
            Transport.send(mimeMessage);
            System.out.println("Sent success.....");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
