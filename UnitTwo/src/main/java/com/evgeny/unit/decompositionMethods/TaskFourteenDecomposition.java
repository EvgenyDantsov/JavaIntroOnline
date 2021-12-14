package com.evgeny.unit.decompositionMethods;

//Натуральное число, в записи которого n цифр, называется числом Армстронга,
// если сумма его цифр, возведенная в степень n, равна самому числу.
// Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class TaskFourteenDecomposition {
    public static void main(String[] args) {
        int k;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число k: ");
        k = in.nextInt();
        System.out.print("Числа Армстронга: ");
        checkValueArmstrong(k);
    }

    public static int countDigit(int k) {
        int count = 0;
        while (k > 0) {
            k = k / 10;
            count++;
        }
        return count;
    }

    public static void checkValueArmstrong(int k) {
        int degree, sum = 0, temp, number;
        for (int i = 1; i < k; i++) {
            degree = countDigit(i);
            temp = degree;
            number = i;
            while (temp > 0) {
                sum = (int) (sum + Math.pow(number % 10, degree));
                number = number / 10;
                temp--;
            }
            if (i == sum) {
                System.out.print(i + " ");
            }
            sum = 0;
        }
    }
}