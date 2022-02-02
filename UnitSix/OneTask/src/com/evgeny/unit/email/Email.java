package com.evgeny.unit.email;

import com.evgeny.unit.user.Users;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static com.evgeny.unit.menu.Menu.readInt;
import static com.evgeny.unit.menu.Menu.readString;

public class Email {
    final static String myAccount = "javatestunitsix@gmail.com";
    final static String password = "svuihabfbsumoldq";

    public static void sendEmail(Users users, int user) {
        Address[] addresses;
        System.out.println("send message");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(myAccount));
            if (user == 1) {
                addresses = users.emailAdmin();
            } else {
                addresses = users.emailUser();
            }
            // Set To: header field of the header.
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.addRecipients(Message.RecipientType.BCC, addresses);

            // Set Subject: header field
            if (user == 1) {
                message.setSubject("Prompt to add the new book.");
            } else {
                message.setSubject("Added a new book to the library.");
            }
            // Now set the actual message
            if (user == 1) {
                System.out.print("Title: ");
                String title = readString();
                System.out.print("Author: ");
                String author = readString();
                System.out.print("Publisher: ");
                String publisher = readString();
                System.out.print("Year of publishing: ");
                int year = readInt();
                System.out.print("Is it e-book?" +
                        "\n1 - yes" +
                        "\n2 - no" +
                        "\nSelect: ");
                int choice = readInt();
                if (choice == 1) {
                    String location = readString();
                    message.setText("\n\nEnter about the new book.\nTitle: " + title +
                            "\nAuthor: " + author +
                            "\nPublisher: " + publisher +
                            "\nYear of publishing: " + year +
                            "\nLocation: " + location);
                } else {
                    message.setText("Title: " + title +
                            "\nAuthor: " + author +
                            "\nPublisher: " + publisher +
                            "\nYear of publishing: " + year);
                }
            } else {
                message.setText("Add a new books in library.");
            }
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (
                MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
