package com.evgeny.unit.oneArray;

//В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        int N, K, sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        N = in.nextInt();
        System.out.print("Введите K: ");
        K = in.nextInt();
        int[] array = new int[N];
        System.out.print("Array[" + N + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 99);
            if (array[i] % K == 0) {
                sum = sum + array[i];
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\nСумма элементов кратных " + K + ": " + sum);
    }
}