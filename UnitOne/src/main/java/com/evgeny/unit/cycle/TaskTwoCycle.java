package com.evgeny.unit.cycle;

//Вычислить значения функции на отрезке [а,b] c шагом h:
//y={x,x>2; -x, x<=2.

import java.util.Scanner;

public class TaskTwoCycle {
    public static void main(String[] args) {
        double a, b, h, y = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите начало отрезка a: ");
        a = in.nextInt();
        System.out.print("Введите конец отрезка b: ");
        b = in.nextInt();
        System.out.print("Введите шаг h: ");
        h = in.nextInt();
        while (a <= b) {
            if (a <= 2) {
                y = y - a;
            } else if (a > 2) {
                y = y + a;
            }
            a = a + h;
        }
        System.out.println("y: " + y);
    }
}
