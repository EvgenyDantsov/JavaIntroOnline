package com.evgeny.unit.treasure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {
    static String NAME_FILE = "ListTreasure.txt";
    List<Treasure> treasureList = new ArrayList<>();

    public List<Treasure> searchFile() {//проверка существует ли указанный файл, если нет создается
        try {
            File f = new File(NAME_FILE);
            if (!f.createNewFile() && f.length() != 0) {
                treasureList = deserializationFile(treasureList);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return treasureList;
    }

    public List<Treasure> deserializationFile(List<Treasure> treasureList) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NAME_FILE));
            treasureList = (List<Treasure>) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.print("Data loading.\n");
        return treasureList;
    }

//    public void serializationFile(List<Treasure> treasureList) { // записываются данные в файл
//        System.out.println("Data save.");
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NAME_FILE));
//            oos.writeObject(treasureList);
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }
}
