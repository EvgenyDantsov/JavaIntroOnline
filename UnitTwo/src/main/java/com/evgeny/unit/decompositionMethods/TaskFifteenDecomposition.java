package com.evgeny.unit.decompositionMethods;

//Найти все натуральные n-значные числа, цифры в которых образуют строго
// возрастающую последовательность (например, 1234, 5789).
// Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class TaskFifteenDecomposition {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число от 1 до 9, n: ");
        n = in.nextInt();
        System.out.print(n + "- значные числа, которые образуют строго возрастающую" +
                " последовательность:\n");
        ascendNumber(n);
    }

    public static boolean searchAscendNumber(int i, int n) {
        int tempOne, tempTwo, tempThree = i, count = 0;
        while (n > count) {
            tempTwo = tempThree % 10;
            tempThree = tempThree / 10;
            tempOne = tempThree % 10;
            if (tempTwo > tempOne) {
                count++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void ascendNumber(int n) {
        int degree = (int) Math.pow(10, n), count = 0;
        for (int i = (int) Math.pow(10, n - 1); i < degree; i++) {
            if (n == 1) {
                System.out.print(i + " ");
            } else {
                if (searchAscendNumber(i, n)) {
                    System.out.print(i + " ");
                    count++;
                    if (count == 10) {
                        System.out.println();
                        count = 0;
                    }
                }
            }
        }
    }
}
