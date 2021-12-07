package com.evgeny.unit;

import java.util.LinkedList;

public class Books {
    private LinkedList<Book> listBook = new LinkedList<Book>();
    private int id;

    public Books(LinkedList<Book> listBook) {
        this.listBook = listBook;
        if(!listBook.isEmpty()) {
            this.id = listBook.getLast().getId() + 1;
        }
    }

    public void printAuthor(String nameAuthor) {
        listBook.stream()
                .filter(book -> book.getAuthor().compareTo(nameAuthor) >= 0)
                .forEach(System.out::println);
    }

    public void printPublishingHouse(String namePublishingHouse) {
        listBook.stream()
                .filter(book -> book.getPublishingHouse().compareTo(namePublishingHouse) >= 0)
                .forEach(System.out::println);
    }

    public void printYearOfPublication(int yearOfPublication) {
        listBook.stream()
                .filter(book -> book.getYearOfPublication() > yearOfPublication)
                .forEach(System.out::println);
    }
}
