package com.evgeny.unit.linear;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        double a, b, c, result;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите а: ");
        a = in.nextDouble();;
        System.out.print("\n" + "Введите b: ");
        b = in.nextDouble();
        System.out.print("\n" + "Введите c: ");
        c = in.nextDouble();
        result = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) - (Math.pow(a, 3) * c) + Math.pow(b, -2);
        System.out.println("\n" + "result = " + result);
    }
}
