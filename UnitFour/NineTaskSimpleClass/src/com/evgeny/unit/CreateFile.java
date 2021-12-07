package com.evgeny.unit;

import java.io.*;
import java.util.LinkedList;

public class CreateFile {
    public boolean SearchFile(String nameFile) {//проверка существует ли указанный файл, если нет создается
        boolean existsFile = false;
        try {
            File f = new File(nameFile);
            if (!f.createNewFile() && f.length() != 0) existsFile = true;
            else existsFile = false;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return existsFile;
    }

    public LinkedList<Book> deserializationFile(LinkedList<Book> listBook, String nameFile) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
            listBook = (LinkedList<Book>) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return listBook;
    }

    public void serializationFile(LinkedList<Book> listBook, String nameFile) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile));
            oos.writeObject(listBook);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
