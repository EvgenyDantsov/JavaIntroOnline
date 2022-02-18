package com.evgeny.unit.ship;

public enum Size {
    SMALL(6), MIDDLE(18), LARGE(39);

    Size(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}