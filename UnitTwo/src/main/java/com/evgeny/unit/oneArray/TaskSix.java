package com.evgeny.unit.oneArray;

//Задана последовательность N вещественных чисел.
// Вычислить сумму чисел, порядковые номера которых являются простыми числами.

import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        int N;
        double sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер последовательности: ");
        N = in.nextInt();
        double[] array = new double[N];
        System.out.print("Array[" + N + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 10;
            System.out.format("%.2f", array[i]);
            System.out.print(" ");
            if (primeNumber(i)) {
                sum = sum + array[i];
            }
        }
        System.out.print("\nСумма чисел, порядковый номер которых простые числа: ");
        System.out.format("%.2f", sum);
    }

    static boolean primeNumber(int number) {
        if (number < 2) {
            return false;
        }
        int value = (int) Math.sqrt(number) + 1;
        for (int i = 2; i <= value; i++) {
            if (number == 2) {
                return true;
            } else if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}