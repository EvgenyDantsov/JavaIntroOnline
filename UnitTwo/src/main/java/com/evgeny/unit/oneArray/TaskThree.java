package com.evgeny.unit.oneArray;

// Дан  массив  действительных  чисел,  размерность  которого N.
// Подсчитать,  сколько  в  нем  отрицательных, положительных и нулевых элементов.

import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        int N, countNull = 0, countNegative = 0, countPositive = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        N = in.nextInt();
        int[] array = new int[N];
        System.out.print("Array[" + N + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 20) - 10);
            System.out.print(array[i] + " ");
            if (array[i] > 0) {
                countPositive++;
            } else if (array[i] < 0) {
                countNegative++;
            } else countNull++;
        }
        System.out.println("\nКоличество отрицательных элементов: " + countNegative);
        System.out.println("Количество положительных элементов: " + countPositive);
        System.out.println("Количество нулевых элементов: " + countNull);
    }
}
