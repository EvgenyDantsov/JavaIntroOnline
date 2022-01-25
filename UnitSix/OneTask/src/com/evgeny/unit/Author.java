package com.evgeny.unit;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {
    private int id;
    private String fio;

    public Author(){
    }

    public Author(String fio) {
        this.fio = fio;
    }

    public Author(String fio, Date birthday) {
        this.fio = fio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
