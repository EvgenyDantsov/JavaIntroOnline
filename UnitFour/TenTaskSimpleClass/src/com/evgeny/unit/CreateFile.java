package com.evgeny.unit;

import java.io.*;

public class CreateFile {
    static String NAME_FILE = "Airline.txt";
    Airline[] airline = new Airline[1];

    public Airline[] searchFile() {//проверка существует ли указанный файл, если нет создается
        try {
            File f = new File(NAME_FILE);
            if (!f.createNewFile() && f.length() != 0) {
                airline = deserializationFile(airline);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return airline;
    }

    public Airline[] deserializationFile(Airline[] airline) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NAME_FILE));
            airline = (Airline[]) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return airline;
    }

    public void serializationFile(Airline[] airline) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NAME_FILE));
            oos.writeObject(airline);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
