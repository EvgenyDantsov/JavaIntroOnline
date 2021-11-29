package com.evgeny.unit;

public class Test1 {
    int one, two;

    int sum() {
        return one + two;
    }

    int max() {
        if (one > two) {
            return one;
        }
        return two;
    }
}
