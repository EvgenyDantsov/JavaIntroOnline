package com.evgeny.unit;

import java.io.*;

public class CreateFile {
    static String NAME_FILE = "Book.txt";
    Book[] book = new Book[1];

    public Book[] SearchFile() {//проверка существует ли указанный файл, если нет создается
        try {
            File f = new File(NAME_FILE);
            if (!f.createNewFile() && f.length() != 0) {
                book = deserializationFile(book, NAME_FILE);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return book;
    }

    public Book[] deserializationFile(Book[] book, String nameFile) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
            book = (Book[]) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return book;
    }

    public void serializationFile(Book[] book, String nameFile) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile));
            oos.writeObject(book);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}