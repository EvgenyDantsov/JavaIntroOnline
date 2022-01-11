package com.evgeny.unit;

import java.io.File;
import java.util.Scanner;

public class Directory {
    public static String folderPath= "/JavaIntroOnline/UnitFive/OneTaskBasicOOP/";
    Scanner in = new Scanner(System.in);
    private String nameFolder;

    public Directory() {
        this.nameFolder = "";
    }

    public Directory(String nameFolder) {
        this.nameFolder = folderPath + nameFolder;
    }

    public String getNameFolder() {
        return nameFolder;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }
    public void createDirectory() {
        System.out.print("Do you want to create a new folder? " +
                "\n1. Yes" +
                "\n2. Enter an existing folder" +
                "\n3. No" +
                "\nSelect: ");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter name directory: ");
                in.nextLine();
                setNameFolder(folderPath + in.nextLine());
                File f = new File(getNameFolder());
                try {
                    if (f.mkdir()) {
                        System.out.println("Directory Created");
                    } else {
                        System.out.println("Directory is not created");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.print("Enter name directory: ");
                in.nextLine();
                setNameFolder(folderPath + in.nextLine());
                break;
            case 3:
                setNameFolder(folderPath);
                break;
        }
    }
}
