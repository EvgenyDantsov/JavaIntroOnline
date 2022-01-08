package com.evgeny.unit;

public class Directory {
    public static String folderPath= "/JavaIntroOnline/UnitFive/OneTaskBasicOOP/";
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
}
