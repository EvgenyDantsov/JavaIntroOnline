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

    public String getNameFolder() {
        return nameFolder;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }

    public void createDirectory(int value, String string, int count) {
        String folderPathEnter = "" + string;
            switch (value) {
                case 1:
                    System.out.print("Enter name directory: ");
                    setNameFolder(folderPathEnter + "/" + in.nextLine());
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
                    if(count==0) {
                        folderPathEnter = folderPath + folderPathEnter + in.nextLine();
                    } else {
                        folderPathEnter = folderPathEnter + "/" + in.nextLine();
                    }
                    setNameFolder(folderPathEnter);
                    break;
                case 3:
                    setNameFolder(folderPath);
                    break;
            }
        }
}
