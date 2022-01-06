package com.evgeny.unit;

public class Directory {
    private String nameFolder;

    public Directory() {
        this.nameFolder = "";
    }

    public Directory(String nameFolder) {
        this.nameFolder = nameFolder;
    }

    public String getNameFolder() {
        return nameFolder;
    }

    public void setNameFolder(String nameFolder) {
        this.nameFolder = nameFolder;
    }
}
