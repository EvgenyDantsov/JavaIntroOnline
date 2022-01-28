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

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Properties p = new Properties();
        p.setProperty ("mail.transport.protocol", "SMTP"); // Установить протокол отправки почты
        p.setProperty ("mail.smtp.host", "smtp.mail.com"); // Установить почтовый сервер
        p.setProperty ("mail.smtp.port", "25"); // Установить номер порта для отправки почты, по умолчанию 25
        p.setProperty ("mail.smtp.auth", "true"); // аутентификация при входе в систему является истинной
        p.setProperty ("mail.smtp.timeout", "1000"); // Установить время ожидания
        // Технический вход:
        Session mailSession = Session.getDefaultInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = "adriano-sport@mail.ru"; // учетная запись электронной почты xxx@163.com
                String password = "richard2192400adriano"; // пароль
                return new PasswordAuthentication(username, password);
            }
        });
        mailSession.setDebug (true); // Включить режим отладки

        /////////////// Начать инкапсуляцию почтовой информации /////////////////////
        // 1 Создаем почтовый объект и устанавливаем почту для отправки пользователем mailSession
        Message message = new MimeMessage(mailSession);
        // 2 Установить отправителя электронного письма
        try {
            message.setFrom( new InternetAddress("adriano-sport@mail.ru"));
        // 3 устанавливаем получателя почты
        message.setRecipient( MimeMessage.RecipientType.TO, new InternetAddress("richardsaufer@gmail.com"));
        // 4 устанавливаем тему письма
        message.setSubject ("Test it out");
        // 5 устанавливаем содержимое электронной почты
        message.setContent ("Hello world! Hello!", "text / html; charset = utf-8");

        // Отправить !!!
        Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
//        java.util.Properties props = new java.util.Properties();
//        props.put("mail.smtp.host", "smtp.myisp.com");
//        Session session = Session.getDefaultInstance(props, null);
//
//// Construct the message
//        String to = "adriano-sport@mail.ru";
//        String from = "me@me.com";
//        String subject = "Hello";
//        Message msg = new MimeMessage(session);
//        try {
//            msg.setFrom(new InternetAddress(from));
//            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            msg.setSubject(subject);
//            msg.setText("Hi,\n\nHow are you?");
//
//            // Send the message.
//            Transport.send(msg);
//            System.out.println("message send");
//        } catch (MessagingException e) {
//            // Error.
//        }
        //Menu.choiceMenu();
    }
}