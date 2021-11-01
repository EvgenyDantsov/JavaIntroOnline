package com.evgeny.unit.decompositionMethods;

//Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
// Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class TaskSixteenDecomposition {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число от 1 до 9, n: ");
        n = in.nextInt();
        if (n > 0 && n < 9) {
            sumOddNumber(n);
        } else System.out.println("Введены некорректные данные.");
    }

    public static boolean searchOddNumber(int number) {
        int temp;
        while (number != 0) {
            temp = number % 10;
            if (temp % 2 != 0) {
                number = number / 10;
            } else return false;
        }
        return true;
    }

    public static void sumOddNumber(int n) {
        int sum = 0;
        for (int i = (int) Math.pow(10, n - 1); i < Math.pow(10, n); i++) {
            if (searchOddNumber(i)) {
                sum = sum + i;
            }
        }
        System.out.println("Сумма " + n + "-значных чисел, содержащих только нечетные числа: " + sum);
        searchEvenNumberToSum(sum);
    }

    public static void searchEvenNumberToSum(int number) {
        int temp, count = 0;
        while (number > 0) {
            temp = number % 10;
            if (temp % 2 == 0 && temp != 0) {
                count++;
            }
            number = number / 10;
        }
        System.out.println("Количество четных чисел в сумме: " + count);
    }
}
