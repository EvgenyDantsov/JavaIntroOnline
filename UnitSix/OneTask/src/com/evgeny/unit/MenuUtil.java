package com.evgeny.unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
public class MenuUtil {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static void printBooks(List<Book> books) {
        int index = 0;
        while (true) {
            for (int i = index; i < Integer.min(books.size(), index + 4); i++) {
                System.out.println(books.get(i));
            }
            System.out.print("0 - exit" +
                    "\n1 - next page;" +
                    "\n2 - previous page" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                return;
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

    private static User getUser(boolean admin) {
        System.out.print("Enter email: ");
        String email = readString();
        System.out.print("Enter login: ");
        String login = readString();
        System.out.print("Enter password: ");
        String password = readString();
        return new User(login, email, password, admin);
    }

    private static void findBook(BookUtil books) {
        while (true) {
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

    private static void addBook(BookUtil books) {
        boolean isAddBook = true;
        System.out.print("Adding new book" +
                "\nTitle: ");
        String title = readString();
        System.out.print("Author: ");
        String author = readString();
        System.out.print("Publisher: ");
        String publisher = readString();
        System.out.print("Year of publishing: ");
        int year = readInt();
        readString();
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

    private static void removeBook(BookUtil books) {
        System.out.print("Enter book id: ");
        int id = readInt();
        if (books.removeBook(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error: book is not found");
        }
    }

    public static void choiceMenu() {
        UserUtil users = new UserUtil();
        BookUtil books = new BookUtil();
        boolean logged = false;
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
                    User newUser = getUser(false);
                    if (!users.checkLogin(newUser.getLogin())) {
                        System.out.println("This username is used by another user");
                        System.out.println("Registration cancelled");
                    } else {
                        users.addUser(newUser);
                    }
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
                    break;
                case 3:
                    System.out.print("Enter login: ");
                    String login = readString();
                    System.out.print("Enter password: ");
                    String password = readString();
                    user = users.login(login, password);
                    if (user == null) {
                        System.out.println("Failed");
                    } else {
                        System.out.println("Ok, logged");
                        logged = true;
                    }
                    System.out.println("Press enter to continue...");
                    readString();
                    if (user != null) {
                        if (user.isAdmin()) {
                            bookMenuAdmin(books);
                        } else {
                            bookMenuUser(books);
                        }
                        user.logout();
                        users.saveToFile();
                        books.saveToFile();
                    }
                    break;
            }
        }
    }

    private static void bookMenuAdmin(BookUtil books) {
        while (true) {
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
                    printBooks(books.filterByYear(Integer.MIN_VALUE, Integer.MAX_VALUE));
                    break;
                case 3:
                    addBook(books);
                    break;
                case 4:
                    removeBook(books);
                    break;
            }
        }
    }

    private static void bookMenuUser(BookUtil books) {
        while (true) {
            System.out.print("Menu" +
                    "\n0. Exit" +
                    "\n1. Find book" +
                    "\n2. Show all books" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                choiceMenu();
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
                    printBooks(books.filterByYear(Integer.MIN_VALUE, Integer.MAX_VALUE));
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
