package com.evgeny.unit.decompositionMethods;

//Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
//натуральных чисел: НОК(А,В)=А*В/НОД(А,В).

import java.util.Scanner;

public class TaskOneDecomposition {
    public static void main(String[] args) {
        int a, b;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число a: ");
        a = in.nextInt();
        System.out.print("Введите натуральное число b: ");
        b = in.nextInt();
        System.out.print("Наибольший общий делитель " + a + " и " + b + ": " + nod(a, b));
        System.out.print("\nНаименьшее общее кратное " + a + " и " + b + ": " + nok(a, b));
    }

    public static int nod(int a, int b) {
        return b == 0 ? a : nod(b, a % b);
    }

    public static int nok(int a, int b) {
        return a * b / nod(a, b);
    }
}
