package com.evgeny.unit.branching;

import java.util.Scanner;

//Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
// Определить, пройдет ли кирпич через отверстие.

public class TaskFourBranch {
    public static void main(String[] args) {
        int A, B, x, y, z;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите A: ");
        A = in.nextInt();
        System.out.print("Введите B: ");
        B = in.nextInt();
        System.out.print("Введите x: ");
        x = in.nextInt();
        System.out.print("Введите y: ");
        y = in.nextInt();
        System.out.print("Введите z: ");
        z = in.nextInt();
        if (A > 0 && B > 0) {
            if (x > 0 && y > 0 && z > 0) {
                if (A >= x && B >= y || A >= y && B >= x) {
                    System.out.println("Кирпич проходит в отверстие.");
                } else if (A >= x && B >= z || A >= z && B >= x) {
                    System.out.println("Кирпич проходит в отверстие.");
                } else if (A >= z && B >= y || A >= y && B >= z) {
                    System.out.println("Кирпич проходит в отверстие.");
                } else System.out.println("Кирпич не проходит в отверстие.");
            } else System.out.println("Размеры кирпича не могут быть отрицательными значениями.");
        } else System.out.println("Отверстие не может быть с отрицательными значениями.");
    }
}