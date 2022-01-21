package com.evgeny.unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MenuUtil {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int choicePosition(int min, int max) {
        int res = readInt();
        if (res < min || res > max) {
            System.out.println("Invalid input: try again");
            return choicePosition(min, max);
        }else {
            return res;
        }
    }

    private static void printBooks(List<Book> books) {
        int index = 0;
        while (true) {
            for (int i = index; i < Integer.min(books.size(), index + 4); i++) {
                System.out.println(books.get(i));
            }

            System.out.println("1 - next page, 2 - previous page, 3 - exit");
            int choice = choicePosition(1, 3);
            if (choice == 1) {
                index += 4;
                if (index >= books.size()) {
                    index -= 4;
                }
            } else if (choice == 2) {
                index = Integer.max(0, index - 4);
            } else {
                return;
            }
        }
    }

    private static User getUser(boolean admin) {
        System.out.println("Enter email: ");
        String email = readString();
        System.out.println("Enter login: ");
        String login = readString();
        System.out.println("Enter password: ");
        String password = readString();

        return new User(login, email, password, admin);

    }

    private static void findBook(BookUtil books) {
        System.out.println("1. Search by id");
        System.out.println("2. Search by title");
        System.out.println("3. Search by author");
        System.out.println("4. Search by publisher");
        System.out.println("5. Search by year of publishing");
        int choice2 = choicePosition(1, 5);

        if (choice2 == 1) {
            System.out.print("Enter id:");
            int id = choicePosition(0, Integer.MAX_VALUE);
            Book book = books.findBookById(id);
            System.out.println(book == null ? "Book is not found" : book);

        } else if (choice2 == 2) {
            System.out.print("Enter title:");
            String title = readString();
            List<Book> filtered = books.filterByTitle(title);
            printBooks(filtered);

        } else if (choice2 == 3) {
            System.out.print("Enter author:");
            String author = readString();
            List<Book> filtered = books.filterByAuthor(author);
            printBooks(filtered);

        } else if (choice2 == 4) {
            System.out.print("Enter publisher:");
            String publisher = readString();
            List<Book> filtered = books.filterByPublisher(publisher);
            printBooks(filtered);

        } else if (choice2 == 5) {
            System.out.print("Enter range start year and finish year:");
            int startYear = readInt();
            int finishYear = readInt();
            readString();

            List<Book> filtered = books.filterByYear(startYear, finishYear);
            printBooks(filtered);
        }
    }


    private static void addBook(BookUtil books) {

        System.out.println("Adding new book...");
        System.out.print("Title: ");
        String title = readString();
        System.out.print("Author: ");
        String author = readString();
        System.out.print("Publisher: ");
        String publisher = readString();
        System.out.print("Year of publishing: ");
        int year = readInt();
        readString();

        Book book;
        System.out.println("Is it e-book? (1 - yes, 2 - no)");
        int choice3 = choicePosition(1, 2);
        if (choice3 == 1) {
            System.out.println("Enter web location of this book (URL, website, etc.)");
            String location = readString();
            book = new Ebook(0, title, new Author(author), new Publisher(publisher), year, location);
        } else {
            book = new Book(0, title, new Author(author), new Publisher(publisher), year);
        }

        books.addBook(book);
    }

    private static void removeBook(BookUtil books) {

        System.out.println("Enter book id: ");
        int id = choicePosition(Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (books.removeBook(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("Error: book is not found");
        }
    }

    public static void choiceMenu(){
        UserUtil users = new UserUtil();
        BookUtil books = new BookUtil();

        boolean logged = false;
        User user = null;

        while (!logged) {
            System.out.println("1. Register new user");
            System.out.println("2. Register new admin");
            System.out.println("3. Login");
            int choice = choicePosition(1, 3);

            if (choice == 1) {

                User newUser = getUser(false);

                if (!users.checkLogin(newUser.getLogin())) {
                    System.out.println("This username is used by another user");
                    System.out.println("Registration cancelled");
                } else {
                    users.addUser(newUser);
                }

            } else if (choice == 2) {
                System.out.println("Enter master password: ");
                String masterPassword = readString();
                if (users.loginMaster(masterPassword)) {
                    System.out.println("OK\n");

                    User newUser = getUser(true);

                    if (!users.checkLogin(newUser.getLogin())) {
                        System.out.println("This username is used by another user");
                        System.out.println("Registration cancelled");
                    } else {
                        users.addUser(newUser);
                    }
                }
            } else {
                System.out.println("Enter login: ");
                String login = readString();
                System.out.println("Enter password: ");
                String password = readString();
                user = users.login(login, password);
                if (user == null) {
                    System.out.println("Failed");
                } else {
                    System.out.println("Ok, logged");
                    logged = true;
                }
            }

            System.out.println("Press enter to continue...");
            readString();
        }

        boolean exit = false;

        if (user.isAdmin()) {
            bookMenuAdmin(exit, books);
        } else {
            bookMenuUser(exit, books);
        }
        user.logout();

        users.saveToFile();
        books.saveToFile();
    }

    private static void bookMenuAdmin(boolean exit, BookUtil books){
        while (!exit) {
            System.out.println("Menu");
            System.out.println("1. Find book");
            System.out.println("2. Show all books");
            System.out.println("3. Add new book");
            System.out.println("4. Remove book");
            System.out.println("5. Exit");
            int choice = choicePosition(1, 5);

            if (choice == 1) {
                findBook(books);
            } else if (choice == 2) {
                printBooks(books.filterByYear(Integer.MIN_VALUE, Integer.MAX_VALUE));
            } else if (choice == 3) {
                addBook(books);
            } else if (choice == 4) {
                removeBook(books);
            } else if (choice == 5) {
                exit = true;
            }
        }
    }

    private static void bookMenuUser(boolean exit, BookUtil books){
        while (!exit) {
            System.out.println("Menu");
            System.out.println("1. Find book");
            System.out.println("2. Show all books");
            System.out.println("3. Exit");
            int choice = choicePosition(1, 3);

            if (choice == 1) {
                findBook(books);
            } else if (choice == 2) {
                printBooks(books.filterByYear(Integer.MIN_VALUE, Integer.MAX_VALUE));
            } else if (choice == 3) {
                exit = true;
            }
        }
    }
    public static int readInt(){
        try {
            int i = Integer.parseInt(readString());
            return i;
        } catch (NumberFormatException e) {
            System.out.println("An error occurred while trying to enter a number. Try again.");
            return readInt();
        }
    }
    public static String readString(){

        try {
            String string = bufferedReader.readLine();
            return string;
        } catch (IOException e) {
            System.out.println("An error occurred while trying to enter text. Try again.");
            return readString();
        }
    }
}
