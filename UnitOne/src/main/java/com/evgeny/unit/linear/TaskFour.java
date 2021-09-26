package com.evgeny.unit.linear;

public class TaskFour {
    public static void main(String[] args) {
        double R = 321.123;
        System.out.println(R);
        System.out.println((R * 1000) % 1000 + (int) R / 1000.0);
    }
}
