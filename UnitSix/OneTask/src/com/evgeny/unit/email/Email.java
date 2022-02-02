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
        properties.put("mail.smtp.auth", "true"); //аутентификация при входе в систему
        properties.put("mail.smtp.starttls.enable", "true"); //	Разрешается использовать команду STARTTLS (если она поддерживается сервером) для переключения соединения на соединение, защищенное TLS, перед выполнением каких-либо команд входа в систему.
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Установливаем почтовый сервер для подключения
        properties.put("mail.smtp.port", "465"); //Установливаем номер порта для отправки почты
        properties.put("mail.smtp.ssl.enable", "true"); //Используется SSL для подключения и используйтся порт SSL по умолчанию.
        //properties.put("mail.debug", "true"); //включение режима отладки
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.put("mail.smtp.socketFactory.port", "465"); //Определяем порт для подключения при использовании указанной фабрики сокетов.
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Указываем имя класса, который реализует интерфейс javax.net.SocketFactory. Этот класс будет использоваться для создания SMTP-сокетов.

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccount, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session); //Создаем почтовый объект и устанавливаем почту для отправки пользователем session
            message.setFrom(new InternetAddress(myAccount)); //Устанавливаем отправителя почты
            if (user == 1) {
                addresses = users.emailAdmin();
            } else {
                addresses = users.emailUser();
            }
            message.addRecipients(Message.RecipientType.BCC, addresses); //Устанавливаем получателей почты
            if (user == 1) {
                message.setSubject("Prompt to add the new book."); //Устанавливаем тему письма
            } else {
                message.setSubject("Added a new book to the library."); //Устанавливаем тему письма
            }
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
                            "\nLocation: " + location); //Устанавливаем текст сообщения
                } else {
                    message.setText("Title: " + title +
                            "\nAuthor: " + author +
                            "\nPublisher: " + publisher +
                            "\nYear of publishing: " + year); //Устанавливаем текст сообщения
                }
            } else {
                message.setText("Add a new books in library."); //Устанавливаем текст сообщения
            }
            System.out.println("sending...");
            Transport.send(message); //Отправляем письмо
            System.out.println("Sent message successfully....");
        } catch (
                MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
