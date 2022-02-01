package com.evgeny.unit.menu;

import com.evgeny.unit.book.*;
import com.evgeny.unit.email.Email;
import com.evgeny.unit.user.User;
import com.evgeny.unit.user.Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Objects;

public class Menu {
    private final static String salt = "DGE$5SGr@3VsHYUMas2323E4d57vfBfFSTRU@!DSH(*%FDSdfg13sgfsg";
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static boolean isBookMenuAdmin = true, isBookMenuUser = true, isPrint = true, isFindBook = true, logged = false;

    private static void printBooks(List<Book> books) { // постраничный вывод книг (по 4 книги на странице)
        isPrint = true;
        int index = 0;
        while (isPrint) {
            for (int i = index; i < Integer.min(books.size(), index + 4); i++) {
                System.out.println(books.get(i));
            }
            System.out.print("0 - exit" +
                    "\n1 - next page;" +
                    "\n2 - previous page" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                isPrint = false;
                break;
            }
            if (choice < 1 || choice > 2) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    index += 4;
                    if (index >= books.size()) {
                        index -= 4;
                    }
                    break;
                case 2:
                    index = Integer.max(0, index - 4);
                    break;
            }
        }
    }

    private static User getUser(boolean admin) { // добавление нового пользователя
        System.out.print("Enter email: ");
        String email = readString();
        System.out.print("Enter login: ");
        String login = readString();
        System.out.print("Enter password: ");
        String securedPassword = md5Hash(readString());
        return new User(login, email, securedPassword, admin);
    }

    private static void findBook(Books books) throws NoSuchAlgorithmException, InvalidKeySpecException { //поиск книги по выбранному параметру
        isBookMenuUser = true;
        while (isFindBook) {
            List<Book> filtered;
            System.out.print("0. Exit" +
                    "\n1. Search by id" +
                    "\n2. Search by title" +
                    "\n3. Search by author" +
                    "\n4. Search by publisher" +
                    "\n5. Search by year of publishing" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                bookMenuAdmin(books);
                isFindBook = false;
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Incorrect menu item selected, reenter.");
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter id: ");
                    int id = readInt();
                    Book book = books.findBookById(id);
                    System.out.println(book == null ? "Book is not found" : book);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title = readString();
                    filtered = books.filterByTitle(title);
                    printBooks(filtered);
                    break;
                case 3:
                    System.out.print("Enter author: ");
                    String author = readString();
                    filtered = books.filterByAuthor(author);
                    printBooks(filtered);
                    break;
                case 4:
                    System.out.print("Enter publisher: ");
                    String publisher = readString();
                    filtered = books.filterByPublisher(publisher);
                    printBooks(filtered);
                    break;
                case 5:
                    System.out.print("Enter start year: ");
                    int startYear = readInt();
                    System.out.print("Enter finish year: ");
                    int finishYear = readInt();
                    readString();
                    filtered = books.filterByYear(startYear, finishYear);
                    printBooks(filtered);
                    break;
            }
        }
    }

    private static void addBook(Books books) { // добавление новой книги
        boolean isAddBook = true;
        System.out.print("Adding new book.\nTitle: ");
        String title = readString();
        System.out.print("Author: ");
        String author = readString();
        System.out.print("Publisher: ");
        String publisher = readString();
        System.out.print("Year of publishing: ");
        int year = readInt();
        Book book;
        while (isAddBook) {
            System.out.print("Is it e-book?" +
                    "\n1 - yes" +
                    "\n2 - no" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Enter web location of this book (URL, website, etc.):");
                    String location = readString();
                    book = new Ebook(0, title, new Author(author), new Publisher(publisher), year, location);
                    books.addBook(book);
                    isAddBook = false;
                    break;
                case 2:
                    book = new Book(0, title, new Author(author), new Publisher(publisher), year);
                    books.addBook(book);
                    isAddBook = false;
                    break;
            }
        }
    }

    private static void removeBook(Books books) { //удаление книги по id
        System.out.print("Enter book id: ");
        int id = readInt();
        if (books.removeBook(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error: book is not found");
        }
    }

    public static void choiceMenu() throws NoSuchAlgorithmException, InvalidKeySpecException { //главное меню
        Users users = new Users();
        Books books = new Books();
        User user = null;
        while (!logged) {
            System.out.print("0. Exit" +
                    "\n1. Register new user" +
                    "\n2. Register new admin" +
                    "\n3. Login" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                logged = true;
                break;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    Email.sendEmail(users);
                    User newUser = getUser(false);
//                    if (!users.checkLogin(newUser.getLogin())) {
//                        System.out.println("This username is used by another user");
//                        System.out.println("Registration cancelled");
//                    } else {
//                        users.addUser(newUser);
//                    }
//                    users.saveToFile();
                    break;
                case 2:
                    System.out.print("Enter master password: ");
                    String masterPassword = readString();
                    if (users.loginMaster(masterPassword)) {
                        System.out.println("OK\n");
                        newUser = getUser(true);
                        if (!users.checkLogin(newUser.getLogin())) {
                            System.out.println("This username is used by another user");
                            System.out.println("Registration cancelled");
                        } else {
                            users.addUser(newUser);
                        }
                    }
                    users.saveToFile();
                    break;
                case 3:
                    System.out.print("Enter login: ");
                    String login = readString();
                    System.out.print("Enter password: ");
                    String securedPassword = md5Hash(readString());
                    user = users.login(login, securedPassword);
                    if (user == null) {
                        System.out.println("Failed");
                    } else {
                        System.out.println("Ok, logged");
                    }
                    System.out.println("Press enter to continue...");
                    readString();
                    if (Objects.requireNonNull(user).isAdmin()) {
                        bookMenuAdmin(books);
                    } else {
                        bookMenuUser(books);
                    }
                    Objects.requireNonNull(user).logout();
                    break;
            }
        }
    }

    public static String md5Hash(String message) {  //шифрование пароля
        String md5 = "";
        if (null == message)
            return null;
        message = message + salt; //добавляем соли в строку перед хешированием
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");  //создаемMessageDigest объект для MD5
            digest.update(message.getBytes(), 0, message.length());  //обновляем входную строку в сообщении digest
            md5 = new BigInteger(1, digest.digest()).toString(16);  //Преобразуем сообщение digest значение в 16 (шестнадцатериное значение)
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }

    private static void bookMenuAdmin(Books books) throws NoSuchAlgorithmException, InvalidKeySpecException { //меню администратора
        isBookMenuAdmin = true;
        while (isBookMenuAdmin) {
            System.out.print("Menu" +
                    "\n0. Exit" +
                    "\n1. Find book" +
                    "\n2. Show all books" +
                    "\n3. Add new book" +
                    "\n4. Remove book" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                choiceMenu();
                isBookMenuAdmin = false;
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    findBook(books);
                    break;
                case 2:
                    printBooks(books.listAllBook());
                    break;
                case 3:
                    addBook(books);
                    books.saveToFile();
                    break;
                case 4:
                    removeBook(books);
                    break;
            }
        }
    }

    private static void bookMenuUser(Books books) throws NoSuchAlgorithmException, InvalidKeySpecException { //меню пользователя
        isBookMenuUser = true;
        while (isBookMenuUser) {
            System.out.print("Menu" +
                    "\n0. Exit" +
                    "\n1. Find book" +
                    "\n2. Show all books" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                choiceMenu();
                isBookMenuUser = false;
                break;
            }
            if (choice < 1 || choice > 2) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    findBook(books);
                    break;
                case 2:
                    printBooks(books.listAllBook());
                    break;
            }
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("An error occurred while trying to enter a number. Try again.");
            return readInt();
        }
    }

    public static String readString() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to enter text. Try again.");
            return readString();
        }
    }
}
