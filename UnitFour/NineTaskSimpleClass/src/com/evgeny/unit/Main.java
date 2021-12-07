package com.evgeny.unit;

//Создать класс Book, спецификация которого приведена ниже. Определить конструкторы,
// set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив
// типа Book, с подходящими конструкторами и методами. Задать критерии выбора
// данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//        Найти и вывести:
//        a) список книг заданного автора;
//        b) список книг, выпущенных заданным издательством;
//        c) список книг, выпущенных после заданного года.

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean existsFile;
        String nameFile = "Book.txt";
        LinkedList<Book> listBook = new LinkedList<Book>();
        CreateFile cf = new CreateFile();
        existsFile = cf.SearchFile(nameFile);
        if (existsFile) {
            listBook = cf.deserializationFile(listBook, nameFile);
        }
        Scanner in = new Scanner(System.in);
        Books books = new Books(listBook);
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
                cf.serializationFile(listBook, nameFile);
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    Book book = Book.getBook(in);
                    listBook.add(book);
                    break;
                case 2:
                    System.out.print("Введите автора: ");
                    String nameAuthor = in.next();
                    books.printAuthor(nameAuthor);
                    break;
                case 3:
                    System.out.print("Введите издательство: ");
                    String namePublishingHouse = in.next();
                    books.printPublishingHouse(namePublishingHouse);
                    break;
                case 4:
                    System.out.print("Введите год: ");
                    int yearOfPublication = in.nextInt();
                    books.printYearOfPublication(yearOfPublication);
                    break;
            }
        }
    }
}
