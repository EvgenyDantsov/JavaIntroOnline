package com.evgeny.unit;

import java.io.*;
import java.util.Scanner;

public class Files {
    private String nameFile;
    private String textFile;
    private StringBuilder stringBuilder;
    Scanner in = new Scanner(System.in);
    File file;

    public Files() {
        this.nameFile = "";
        try {
            file = new File(getNameFile());
            if (file.length() != 0) {
                this.textFile = deserializationFile(textFile);
            } else this.textFile = "";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.stringBuilder = new StringBuilder(getTextFile());
        this.file = new File(getNameFile());
    }

    public Files(String nameFile) {
        this.nameFile = nameFile;
        try {
            file = new File(getNameFile());
            if (!file.createNewFile() && file.length() != 0) {
                this.textFile = deserializationFile(textFile);
            } else this.textFile = "";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.stringBuilder = new StringBuilder(getTextFile());
        this.file = new File(getNameFile());
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getTextFile() {
        return textFile;
    }

    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }

    public File getFile() {
        return file;
    }

    public void setFile(String nameFile) {
        this.file = new File(nameFile);
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(String textFile) {
        this.stringBuilder = new StringBuilder(textFile);
    }

    public String searchAndCreateFile() {
        try {
            setFile(getNameFile());
            if (!getFile().createNewFile() && getFile().length() != 0) {
                setTextFile(deserializationFile(getTextFile()));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return textFile;
    }

    public String deserializationFile(String textFile) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getNameFile()));
            textFile = (String) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.print("Data loading.\n");
        return textFile;
    }

    public void serializationFile(String textFile) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getNameFile()));
            oos.writeObject(textFile);
            oos.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void printContentFile() {
        System.out.print("Enter the path to the file: ");
        in.nextLine();
        setNameFile(in.nextLine());
        setTextFile(deserializationFile(getTextFile()));
        System.out.println(getTextFile());
    }

    public void addText() {
        System.out.print("Enter the path to the file: ");
        in.nextLine();
        setNameFile(in.nextLine());
        setFile(getNameFile());
        if (getFile().exists()) {
            if (getFile().length() != 0) {
                setTextFile(deserializationFile(getTextFile()));
            }
            System.out.print("Enter text: ");
            setStringBuilder(String.valueOf(getStringBuilder().append(" ")
                    .append(in.nextLine())));
            setTextFile(stringBuilder.toString());
            serializationFile(getTextFile());
        } else System.out.println("File doesn't exist");
    }

    public void deleteFile() {
        System.out.print("Enter name file: ");
        in.nextLine();
        File fileDeleted = new File(in.nextLine());
        fileDeleted.delete();
    }

    public void menu() {
        while (true) {
            System.out.print(
                    "Select the menu item:\n" +
                            "0. Exit\n" +
                            "1. Create new file\n" +
                            "2. Display the contents of the file on the console\n" +
                            "3. Supplement file\n" +
                            "4. Delete file\n" +
                            "Enter the menu item number: ");
            int choice = in.nextInt();
            if (choice == 0) {
                if (getFile().exists()) {
                    serializationFile(getTextFile());
                }
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter name file: ");
                    in.nextLine();
                    setNameFile(in.nextLine());
                    searchAndCreateFile();
                    break;
                case 2:
                    printContentFile();
                    break;
                case 3:
                    addText();
                    break;
                case 4:
                    deleteFile();
                    break;
            }
        }
    }
}
