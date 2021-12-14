package com.evgeny.unit.arrayArray;

//Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.

import java.util.Scanner;

public class TaskOneArray {
    public static void main(String[] args) {
        int n, count = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        n = in.nextInt();
        int[][] array = new int[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Нечетные столбцы у которых первый элемент больше последнего:\n");
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 2 != 0 && array[i][0] > array[i][n - 1]) {
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            } else count++;
        }
        if (count == n) System.out.print("Таких столбцов нету!");
    }
}