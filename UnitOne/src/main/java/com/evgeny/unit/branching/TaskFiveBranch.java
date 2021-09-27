package com.evgeny.unit.branching;

import java.util.Scanner;

public class TaskFiveBranch {
    public static void main(String[] args) {
        int x;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите x: ");
        x = in.nextInt();
        if (x <= 3) {
            System.out.println("f: " + (Math.pow(x, 2) - 3 * x + 9));
        } else System.out.println("f: " + (1 / (Math.pow(x, 3) + 6)));
    }
}
