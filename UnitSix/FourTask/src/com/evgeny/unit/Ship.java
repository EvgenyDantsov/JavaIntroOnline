package com.evgeny.unit;

import java.util.Random;

public class Ship {

    private int count;
    private Size size;
    private int numberShip;

    public Ship(int numberShip) {
        this.size = getRandomSize();
        this.numberShip = numberShip;
    }

    public void add(int count) {
        this.count += count;
    }

    public boolean countCheck() {
        if (count >= size.getValue()) {
            return false;
        }
        return true;
    }

    public int getNumberShip() { return numberShip; }

    public int getCount() {
        return count;
    }

    public Size getSize() {
        return size;
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}