package com.evgeny.unit;

import java.io.Serializable;
//id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
public class Book implements Serializable {
    private static int idGenerator;
    private int id, yearOfPublication, countPage, price;
    private String nameBook, author, publishingHouse, typeBinding;
    public Book(){}
    public Book(String nameBook, String author, String publishingHouse, int yearOfPublication,
                int countPage, int price, String typeBinding){
        id = idGenerator++;
        this.nameBook = nameBook;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearOfPublication = yearOfPublication;
        this.countPage = countPage;
        this.price = price;
        this.typeBinding = typeBinding;
    }
}
