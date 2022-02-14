package com.evgeny.unit.ship;

public enum Size {
    SMALL(8), MIDDLE(16), LARGE(32);

    Size(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}