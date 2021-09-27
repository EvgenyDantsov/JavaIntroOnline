package com.evgeny.unit.branching;

import java.util.Scanner;

public class TaskThreeBranch {
    public static void main(String[] args) {
        int x1, y1, x2, y2, x3, y3;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите x1: ");
        x1 = in.nextInt();
        System.out.print("Введите y1: ");
        y1 = in.nextInt();
        System.out.print("Введите x2: ");
        x2 = in.nextInt();
        System.out.print("Введите y2: ");
        y2 = in.nextInt();
        System.out.print("Введите x3: ");
        x3 = in.nextInt();
        System.out.print("Введите y3: ");
        y3 = in.nextInt();
        if (0.5 * ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) == 0) {
            System.out.println("Заданные точки лежат на одной прямой.");
        } else System.out.println("Заданные точки лежат не на одной прямой.");
    }
}
