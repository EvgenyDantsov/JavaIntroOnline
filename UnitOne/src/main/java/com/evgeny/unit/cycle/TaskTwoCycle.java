package com.evgeny.unit.cycle;

//Вычислить значения функции на отрезке [а,b] c шагом h:
//y={x,x>2; -x, x<=2.

import java.util.Scanner;

public class TaskTwoCycle {
    public static void main(String[] args) {
        double a = -2, b = 5, h = 1, y = 0;
        while (a <= b) {
            if (a <= 2) {
                y = y - a;
            } else if (a > 2) {
                y = y + a;
            }
            a = a + h;
        }
        System.out.println("Значение функции y: " + y);
    }
}