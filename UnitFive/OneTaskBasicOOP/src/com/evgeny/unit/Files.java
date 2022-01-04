package com.evgeny.unit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Files {
    private String nameFile;
    private List<String> fileList = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    File file;

    public Files() {
        this.nameFile = "";
        this.fileList = deserializationFile(fileList);
        file = new File(this.nameFile);
    }

    public Files(String nameFile) {
        this.nameFile = nameFile;
        try {
            file = new File(getNameFile());
            if (!file.createNewFile() && file.length() != 0) {
                this.fileList = deserializationFile(fileList);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public List<String> searchAndCreateFile() {
        try {
            file = new File(getNameFile());
            if (!file.createNewFile() && file.length() != 0) {
                fileList = deserializationFile(fileList);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return fileList;
    }

    public List<String> deserializationFile(List<String> fileList) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
            fileList = (List<String>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.print("Data loading.\n");
        return fileList;
    }

    public void serializationFile(List<String> fileList) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile));
            oos.writeObject(fileList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void printContentFile() {
        for (String list : fileList) {
            System.out.println(list);
        }
    }

    public void addText() {
        System.out.print("Enter text: ");
        if (file.length() !=0) {
            setFileList(deserializationFile(getFileList()));
        }else {
            in.nextLine();
            fileList.add(in.nextLine());
        }
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
                            "3. Add file\n" +
                            "4. Delete file\n" +
                            "Enter the menu item number: ");
            int choice = in.nextInt();
            if (choice == 0) {
                File fileSearch = new File(getNameFile());
                if (fileSearch.exists()) {
                    serializationFile(fileList);
                    System.out.println("xxx");
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
