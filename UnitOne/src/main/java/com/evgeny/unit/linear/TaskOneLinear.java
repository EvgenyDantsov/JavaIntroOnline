package com.evgeny.unit.linear;

import java.util.Scanner;

// Найти значение функции z=((a-3)*b/2)+c.

public class TaskOneLinear {
    public static void main(String[] args) {
        double z, a, b, c;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите а: ");
        a = in.nextDouble();
        System.out.print("\n" + "Введите b: ");
        b = in.nextDouble();
        System.out.print("\n" + "Введите c: ");
        c = in.nextDouble();
        z = ((a - 3) * b / 2) + c;
        System.out.println("\n" + "z = " + z);
    }
}