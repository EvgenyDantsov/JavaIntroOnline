package com.evgeny.unit.ship;

public enum Size {
    SMALL(4), MIDDLE(8), LARGE(12);

    Size(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}