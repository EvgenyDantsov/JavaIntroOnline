package com.evgeny.unit.branching;

import java.util.Scanner;

public class TaskTwoBranch {
    public static void main(String[] args) {
        int a, b, c, d;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите a: ");
        a = in.nextInt();
        System.out.print("Введите b: ");
        b = in.nextInt();
        System.out.print("Введите c: ");
        c = in.nextInt();
        System.out.print("Введите d: ");
        d = in.nextInt();
        System.out.println("Max: " + Math.max(Math.min(a, b), Math.min(c, d)));
    }
}
