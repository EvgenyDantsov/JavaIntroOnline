package com.evgeny.unit;

import java.io.*;

public class CreateFile {
    static String NAME_FILE = "Book.txt";
    Book[] book = new Book[1];

    public Book[] searchFile() {//проверка существует ли указанный файл, если нет создается
        try {
            File f = new File(NAME_FILE);
            if (!f.createNewFile() && f.length() != 0) {
                book = deserializationFile(book);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return book;
    }

    public Book[] deserializationFile(Book[] book) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NAME_FILE));
            book = (Book[]) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return book;
    }

    public void serializationFile(Book[] book) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NAME_FILE));
            oos.writeObject(book);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}