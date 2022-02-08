package com.evgeny.unit;

public enum Size {
    SMALL(50), MIDDLE(100), LARGE(200);

    Size(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }
}