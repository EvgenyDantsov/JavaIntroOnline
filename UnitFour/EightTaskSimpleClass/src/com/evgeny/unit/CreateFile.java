package com.evgeny.unit;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class CreateFile {
    public boolean SearchFile(String nameFile) {
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

    public LinkedList<Customer> deserializationFile(LinkedList<Customer> listCustomer, String nameFile) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
            listCustomer = (LinkedList<Customer>) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return listCustomer;
    }

    public void serializationFile(LinkedList<Customer> listCustomer, String nameFile) {
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile));
            oos.writeObject(listCustomer);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
