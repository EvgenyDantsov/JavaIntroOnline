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

    public LinkedList<Airline> deserializationFile(LinkedList<Airline> listAirline, String nameFile) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
            listAirline = (LinkedList<Airline>) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return listAirline;
    }

    public void serializationFile(LinkedList<Airline> listAirline, String nameFile) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile));
            oos.writeObject(listAirline);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
