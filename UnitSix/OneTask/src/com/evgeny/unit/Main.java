package com.evgeny.unit;

//Задание 1: создать консольное приложение “Учет книг в домашней библиотеке”.
//Общие требования к заданию:
//• Система учитывает книги как в электронном, так и в бумажном варианте.
//• Существующие роли: пользователь, администратор.
//• Пользователь может просматривать книги в каталоге книг, осуществлять поиск книг в каталоге.
//• Администратор может модифицировать каталог.
//• *При добавлении описания книги в каталог оповещение о ней рассылается на e-mail всем пользователям
//• **При просмотре каталога желательно реализовать постраничный просмотр
//• ***Пользователь может предложить добавить книгу в библиотеку, переслав её администратору на e-mail.
//• Каталог книг хранится в текстовом файле.
//• Данные аутентификации пользователей хранятся в текстовом файле. Пароль не хранится в открытом виде

import com.evgeny.unit.menu.Menu;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
//        System.out.println("send message");
//        String recipient = "adriano-sport@mail.ru";
//        //String recipient = "richardsaufer@gmail.com";
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        //properties.put("mail.smtp.host", "smtp.mail.ru");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", "465");
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.debug", "true");
//        properties.put("mail.smtp.socketFactory.fallback", "false");
//        properties.put("mail.smtp.socketFactory.port", "465");
//        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        final String myAccount = "javatestunitsix@gmail.com";
//        final String password = "jluphahcyiaaewou";
//
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(myAccount, password);
//                //return new PasswordAuthentication(myAccount, password);
//            }
//        });
//        session.setDebug(true);
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(myAccount));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
//
//            // Set Subject: header field
//            message.setSubject("Subject Line!");
//
//            // Now set the actual message
//            message.setText("This is actual message");
//
//            System.out.println("sending...");
//            // Send message
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }

//        Properties p = new Properties();
//        p.setProperty ("mail.transport.protocol", "SMTP"); // Установить протокол отправки почты
//        p.setProperty ("mail.smtp.host", "smtp.mail.com"); // Установить почтовый сервер
//        p.setProperty ("mail.smtp.port", "25"); // Установить номер порта для отправки почты, по умолчанию 25
//        p.setProperty ("mail.smtp.auth", "true"); // аутентификация при входе в систему является истинной
//        p.setProperty ("mail.smtp.timeout", "1000"); // Установить время ожидания
//        // Технический вход:
//        Session mailSession = Session.getDefaultInstance(p);
//
//        mailSession.setDebug (true); // Включить режим отладки
//
//        /////////////// Начать инкапсуляцию почтовой информации /////////////////////
//        // 1 Создаем почтовый объект и устанавливаем почту для отправки пользователем mailSession
//        Message message = new MimeMessage(mailSession);
//        // 2 Установить отправителя электронного письма
//        try {
//            message.setFrom( new InternetAddress("adriano-sport@mail.ru"));
//        // 3 устанавливаем получателя почты
//        message.setRecipient( MimeMessage.RecipientType.TO, new InternetAddress("richardsaufer@gmail.com"));
//        // 4 устанавливаем тему письма
//        message.setSubject ("Test it out");
//        // 5 устанавливаем содержимое электронной почты
//        message.setContent ("Hello world! Hello!", "text / html; charset = utf-8");
//
//        // Отправить !!!
        Menu.choiceMenu();
    }
}