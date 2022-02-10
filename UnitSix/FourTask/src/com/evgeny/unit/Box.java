package com.evgeny.unit;

public class Box implements Cargo{
    private int number;

    public Box(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
