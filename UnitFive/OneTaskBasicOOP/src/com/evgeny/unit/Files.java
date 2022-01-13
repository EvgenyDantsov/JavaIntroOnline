package com.evgeny.unit;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Files {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private String nameFile;
    private StringBuilder stringBuilder;
    Scanner in = new Scanner(System.in);
    File file;

    public Files() {
        this.nameFile = "";
        try {
            this.file = new File(getNameFile());
            if (file.length() != 0) {
                this.stringBuilder = deserializationFile(stringBuilder);
            } else this.stringBuilder = new StringBuilder("");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.file = new File(getNameFile());
    }

    public Files(String nameFile) {
        this.nameFile = nameFile;
        try {
            this.file = new File(getNameFile());
            if (!this.file.createNewFile() && this.file.length() != 0) {
                this.stringBuilder = deserializationFile(stringBuilder);
            } else this.stringBuilder = new StringBuilder("");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        this.file = new File(getNameFile());
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
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

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = new StringBuilder(stringBuilder);
    }

    public void searchAndCreateFile() {
        try {
            setFile(getNameFile());
            if (!getFile().createNewFile()) {
                System.out.println("File exists.");
            } else {
                System.out.println("Create new file.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public StringBuilder deserializationFile(StringBuilder stringBuilder) {  //извлекаются данные из файла
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getNameFile()));
            stringBuilder = (StringBuilder) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.print("Data loading.\n");
        return stringBuilder;
    }

    public void serializationFile(StringBuilder stringBuilder) { // записываются данные в файл
        System.out.println("Data save.");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getNameFile()));
            oos.writeObject(stringBuilder);
            oos.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void printContentFile() {
        int exitPrint;
        exitPrint = viewFolderContent();
        setNameFile(getFile().toString());
        if (exitPrint != 0) {
            if (getFile().exists()) {
                setStringBuilder(deserializationFile(getStringBuilder()));
                System.out.println(getStringBuilder());
            } else {
                System.out.println("File doesn't exist.");
            }
        }
    }

    public void addText() {
        int exitPrint;
        exitPrint = viewFolderContent();
        setNameFile(getFile().toString());
        if (exitPrint != 0) {
            if (getFile().exists()) {
                if (getFile().length() != 0) {
                    setStringBuilder(deserializationFile(getStringBuilder()));
                }
                System.out.print("Enter text: ");
                setStringBuilder(getStringBuilder().append(" ")
                        .append(in.nextLine()));
                serializationFile(getStringBuilder());
            } else System.out.println("File doesn't exist");
        }
    }

    public void viewFilesInTheFolder() {
        System.out.println("color red: " + ANSI_RED + "folder" + ANSI_RESET +
                "\ncolor green: " + ANSI_GREEN + "file" + ANSI_RESET);
        setFile(Directory.folderPath);
        for (File f : Objects.requireNonNull(getFile().listFiles())) {
            if (f.isDirectory()) {
                System.out.println(ANSI_RED + f.toString().substring(Directory.folderPath.length()) + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + f.toString().substring(Directory.folderPath.length()) + ANSI_RESET);
            }
        }
    }

    public void viewFilesInTheFolder(String string) {
        System.out.println("color red: " + ANSI_RED + "folder" + ANSI_RESET +
                "\ncolor green: " + ANSI_GREEN + "file" + ANSI_RESET);
        setFile(string);
        for (File f : Objects.requireNonNull(getFile().listFiles())) {
            if (f.isDirectory()) {
                System.out.println(ANSI_RED + f.toString().substring(string.length() + "/".length()) + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN + f.toString().substring(string.length() + "/".length()) + ANSI_RESET);
            }
        }
    }

    public void deleteFile() {
        int exitDelete;
        exitDelete = viewFolderContent();
        if (exitDelete != 0) {
            if (getFile().delete()) {
                System.out.println("File deleted.");
            }
        }
    }

    public int viewFolderContent() {
        int count = 0, choice = 0;
        boolean isFolders = true;
        StringBuilder folderPath = new StringBuilder();
        viewFilesInTheFolder();
        while (isFolders) {
            System.out.print("Select an action:" +
                    "\n0. Exit" +
                    "\n1. View the file in the following folder" +
                    "\n2. Select the file" +
                    "\nSelect: ");
            choice = in.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter name folder: ");
                    in.nextLine();
                    folderPath.append(in.nextLine());
                    setFile(Directory.folderPath + folderPath);
                    if (count == 0) {
                        viewFilesInTheFolder(Directory.folderPath + getFile().getName());
                        count++;
                        folderPath.append("/");
                    } else {
                        viewFilesInTheFolder(Directory.folderPath + folderPath);
                        folderPath.append("/");
                    }
                    break;
                case 2:
                    System.out.print("Enter name file: ");
                    in.nextLine();
                    setFile(folderPath + in.nextLine());
                    isFolders = false;
                    break;
            }
        }
        return choice;
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
                    serializationFile(getStringBuilder());
                }
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    int count = 0;
                    viewFilesInTheFolder();
                    Directory directory = new Directory();
                    while (true) {
                        System.out.print("Do you want to create a new folder? " +
                                "\n1. Yes" +
                                "\n2. Enter an existing folder" +
                                "\n3. No" +
                                "\nSelect: ");
                        int value = in.nextInt();
                        if (value == 1 || value == 2) {
                            directory.createDirectory(value, directory.getNameFolder(), count);
                            viewFilesInTheFolder(directory.getNameFolder());
                            count++;
                        } else break;
                    }
                    System.out.print("Enter name file: ");
                    in.nextLine();
                    setNameFile(directory.getNameFolder() + "/" + in.nextLine());
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
