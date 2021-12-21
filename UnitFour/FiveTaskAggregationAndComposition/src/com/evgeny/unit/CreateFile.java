package com.evgeny.unit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {
    static String NAME_FILE = "Tour.txt";
    List<Tour> tourList =  new ArrayList<>();

    public List<Tour> searchFile() {//проверка существует ли указанный файл, если нет создается
        try {
            File f = new File(NAME_FILE);
            if (!f.createNewFile() && f.length() != 0) {
                tourList = deserializationFile(tourList);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return tourList;
    }

    public List<Tour> deserializationFile(List<Tour> tourList) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NAME_FILE));
            tourList = (List<Tour>) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Data loading.\n");
        return tourList;
    }

    public void serializationFile(List tourList) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NAME_FILE));
            oos.writeObject(tourList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
