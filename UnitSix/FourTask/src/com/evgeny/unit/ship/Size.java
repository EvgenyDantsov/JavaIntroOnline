package com.evgeny.unit.ship;

public enum Size {
    SMALL(5), MIDDLE(10), LARGE(15);

    Size(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}