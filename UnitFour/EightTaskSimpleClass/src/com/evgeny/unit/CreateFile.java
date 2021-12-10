package com.evgeny.unit;

import java.io.*;

public class CreateFile {
    static String NAME_FILE = "Customer.txt";
    Customer[] customer = new Customer[1];

    public Customer[] searchFile() {//проверка существует ли указанный файл, если нет создается
        try {
            File f = new File(NAME_FILE);
            if (!f.createNewFile() && f.length() != 0) {
                customer = deserializationFile(customer);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return customer;
    }

    public Customer[] deserializationFile(Customer[] customer) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NAME_FILE));
            customer = (Customer[]) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return customer;
    }

    public void serializationFile(Customer[] customer) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NAME_FILE));
            oos.writeObject(customer);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
