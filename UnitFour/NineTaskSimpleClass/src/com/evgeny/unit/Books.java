package com.evgeny.unit;

import java.util.Arrays;
import java.util.Scanner;

public class Books {
    private Book[] book;
    private int count;
    Scanner in = new Scanner(System.in);

    public Books(Book[] book) {
        this.book = book;
        this.count = sizeBook();
    }

    public void menu() {
        CreateFile cf = new CreateFile();
        while (true) {
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Выйти\n" +
                            "1. Добавить книгу\n" +
                            "2. Вывод списка книг заданного автора\n" +
                            "3. Вывод списка книг, выпущенных заданным издательством\n" +
                            "4. Вывод списка книг, выпущенных после заданного года\n" +
                            "Введите номер пункта меню: ");
            int choice = in.nextInt();
            if (choice == 0) {
                cf.serializationFile(book, CreateFile.NAME_FILE);
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    if (sizeBook() != 0) {
                        if (sizeBook() >= book.length) {
                            book = Arrays.copyOf(book, book.length * 2);
                        }
                        book[sizeBook()] = Book.getBook(in, sizeBook() + 1);
                    } else {
                        book[0] = Book.getBook(in, 1);
                    }
                    break;
                case 2:
                    System.out.print("Введите автора: ");
                    in.nextLine();
                    String nameAuthor = in.nextLine();
                    printAuthor(nameAuthor);
                    break;
                case 3:
                    System.out.print("Введите издательство: ");
                    String namePublishingHouse = in.next();
                    printPublishingHouse(namePublishingHouse);
                    break;
                case 4:
                    System.out.print("Введите год: ");
                    int yearOfPublication = in.nextInt();
                    printYearOfPublication(yearOfPublication);
                    break;
            }
        }
    }

    public int sizeBook() {
        setCount(0);
        for (Book value : book) {
            if (value != null) {
                count++;
            }
        }
        return count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void printAuthor(String nameAuthor) {
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getAuthor().compareTo(nameAuthor) == 0) {
                System.out.print(book[i]);
                System.out.println();
            }
        }
    }

    public void printPublishingHouse(String namePublishingHouse) {
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null && book[i].getPublishingHouse().compareTo(namePublishingHouse) == 0) {
                System.out.print(book[i]);
                System.out.println();
            }
        }
    }

    public void printYearOfPublication(int yearOfPublication) {
        for (int i = 0; i < book.length - 1; i++) {
            if (book[i] != null && book[i].getYearOfPublication() > yearOfPublication) {
                System.out.print(book[i]);
                System.out.println();
            }
        }
    }
}