package com.evgeny.unit;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private static int idGenerator;
    private int id, yearOfPublication, countPage, price;
    private String nameBook, author, publishingHouse, typeBinding;

    public Book(int idFile) {
        setId(idFile);
    }

    public Book( String nameBook, String author, String publishingHouse, int yearOfPublication,
                int countPage, int price, String typeBinding) {
        id = idGenerator++;
        this.nameBook = nameBook;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearOfPublication = yearOfPublication;
        this.countPage = countPage;
        this.price = price;
        this.typeBinding = typeBinding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getTypeBinding() {
        return typeBinding;
    }

    public void setTypeBinding(String typeBinding) {
        this.typeBinding = typeBinding;
    }

    public static Book getBook(Scanner scanner) {
        Book book = new Book("", "", "",
                0, 0, 0, "");
        scanner.nextLine();
        System.out.print("Название книги: ");
        book.nameBook = scanner.nextLine();
        System.out.print("Автор: ");
        book.author = scanner.nextLine();
        System.out.print("Издательство: ");
        book.publishingHouse = scanner.nextLine();
        System.out.print("Год издания: ");
        book.yearOfPublication = scanner.nextInt();
        System.out.print("Количество страниц: ");
        book.countPage = scanner.nextInt();
        System.out.print("Цена: ");
        book.price = scanner.nextInt();
        System.out.print("Тип переплета: ");
        book.typeBinding = scanner.next();
        return book;
    }

    @Override
    public String toString() {
        return id + ". Название книги: " + nameBook + " Автор: " + author +
                " Издательство: " + publishingHouse + " Год издания: " + yearOfPublication +
                "\nКоличество страниц: " + countPage + " Цена: " + price + " Тип переплета: " + typeBinding;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Book book = (Book) obj;
        return yearOfPublication == book.yearOfPublication &&
                countPage == book.countPage &&
                price == book.price &&
                nameBook.equals(book.nameBook) &&
                author.equals(book.author) &&
                publishingHouse.equals(book.publishingHouse) &&
                typeBinding.equals(book.typeBinding);
    }

    @Override
    public int hashCode() {
        return 31 * yearOfPublication + countPage + price + nameBook.hashCode() + author.hashCode() +
                publishingHouse.hashCode() + typeBinding.hashCode();
    }
}
