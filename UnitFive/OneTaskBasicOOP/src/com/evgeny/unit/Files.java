package com.evgeny.unit;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

import static jdk.nashorn.internal.objects.NativeString.substring;

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
        System.out.print("Enter the path to the file: ");
        in.nextLine();
        setNameFile(in.nextLine());
        setFile(getNameFile());
        if (getFile().exists()) {
            setStringBuilder(deserializationFile(getStringBuilder()));
            System.out.println(getStringBuilder());
        } else {
            System.out.println("File doesn't exist.");
        }
    }

    public void addText() {
        System.out.print("Enter the path to the file: ");
        in.nextLine();
        setNameFile(in.nextLine());
        setFile(getNameFile());
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

    public void viewFilesInTheFolder()
    {
        setFile(Directory.folderPath);
        for(File f : Objects.requireNonNull(getFile().listFiles()))
        {
            if(f.isDirectory()) {
                System.out.println(ANSI_RED +  f.toString().substring(Directory.folderPath.length()) + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN +  f.toString().substring(Directory.folderPath.length()) + ANSI_RESET);
            }
        }
    }
//System.out.println(ANSI_RED +  f.toString()
//            .substring(Directory.folderPath.length() + getFile().getName().length()) + ANSI_RESET);
    public void viewFilesInTheFolder(String string)
    {
        setFile(string);
        for(File f : Objects.requireNonNull(getFile().listFiles()))
        {
            if(f.isDirectory()) {
                System.out.println(ANSI_RED +  f.toString()
                        .substring(Directory.folderPath.length() + getFile().getName()
                                .length() + "/".length()) + ANSI_RESET);
            } else {
                System.out.println(ANSI_GREEN +  f.toString()
                        .substring(Directory.folderPath.length() + getFile().getName()
                                .length()+ "/".length()) + ANSI_RESET);
            }
        }
    }

    public void deleteFile() {
        int count = 0;
        boolean deletedFile = true;
        String folderPath = "";
        viewFilesInTheFolder();
        while (deletedFile) {
            System.out.println("1. посмотреть в следующей папке файл" +
                    "\n2. выбрать файл");
            int choice = in.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter name folder: ");
                    in.nextLine();
                    folderPath = folderPath + in.nextLine();
                    setFile(Directory.folderPath + folderPath);
                    if(count == 0) {
                        viewFilesInTheFolder(Directory.folderPath + getFile().getName());
                        count++;
                        folderPath += "/";
                    }else {
                        viewFilesInTheFolder(Directory.folderPath + folderPath);
                        folderPath += "/";
                    }
                    break;
                case 2: System.out.print("Enter name file ");
                    in.nextLine();
                    setFile(Directory.folderPath + in.nextLine());
                    if (getFile().delete()) {
                        System.out.println("File deleted.");
                    }
                    deletedFile = false;
                    break;
            }
        }
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

//                    System.out.print("Enter name directory: ");
//                    in.nextLine();
                    viewFilesInTheFolder();
                    Directory directory = new Directory();
                    System.out.print("Do you want to create a new folder? " +
                            "\n1. Yes" +
                            "\n2. Enter an existing folder" +
                            "\n3. No" +
                            "\nSelect: ");
                    int value = in.nextInt();
                    while (true) {
                        if(value == 2) {
                            directory.createDirectory(value);
                            viewFilesInTheFolder(directory.getNameFolder());
                        }else break;
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
