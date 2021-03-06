package com.evgeny.unit;

import java.io.Serializable;
import java.util.Scanner;

public class Book implements Serializable {
    private int id, yearOfPublication, countPage, price;
    private String nameBook, author, publishingHouse, typeBinding;

    public Book(int id, String nameBook, String author, String publishingHouse, int yearOfPublication,
                int countPage, int price, String typeBinding) {
        this.id = id;
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

    public static Book getBook(Scanner scanner, int idGenerator) {
        Book book = new Book(idGenerator, "", "", "",
                0, 0, 0, "");
        scanner.nextLine();
        System.out.print("???????????????? ??????????: ");
        book.nameBook = scanner.nextLine();
        System.out.print("??????????: ");
        book.author = scanner.nextLine();
        System.out.print("????????????????????????: ");
        book.publishingHouse = scanner.nextLine();
        System.out.print("?????? ??????????????: ");
        book.yearOfPublication = scanner.nextInt();
        System.out.print("???????????????????? ??????????????: ");
        book.countPage = scanner.nextInt();
        System.out.print("????????: ");
        book.price = scanner.nextInt();
        System.out.print("?????? ??????????????????: ");
        book.typeBinding = scanner.next();
        return book;
    }

    @Override
    public String toString() {
        return id + ". ???????????????? ??????????: " + nameBook + " ??????????: " + author +
                " ????????????????????????: " + publishingHouse + " ?????? ??????????????: " + yearOfPublication +
                "\n???????????????????? ??????????????: " + countPage + " ????????: " + price + " ?????? ??????????????????: " + typeBinding;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Book book = (Book) obj;
        return id == book.id && yearOfPublication == book.yearOfPublication &&
                countPage == book.countPage &&
                price == book.price &&
                nameBook.equals(book.nameBook) &&
                author.equals(book.author) &&
                publishingHouse.equals(book.publishingHouse) &&
                typeBinding.equals(book.typeBinding);
    }

    @Override
    public int hashCode() {
        return 31 * id + yearOfPublication + countPage + price + nameBook.hashCode() + author.hashCode() +
                publishingHouse.hashCode() + typeBinding.hashCode();
    }
}