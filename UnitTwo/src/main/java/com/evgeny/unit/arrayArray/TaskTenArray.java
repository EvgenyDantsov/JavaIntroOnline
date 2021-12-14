package com.evgeny.unit.arrayArray;

//Найти положительные элементы главной диагонали квадратной матрицы.

import java.util.Scanner;

public class TaskTenArray {
    public static void main(String[] args) {
        int n = 5, count = 0;
        Scanner in = new Scanner(System.in);
        int[][] array = new int[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) ((Math.random() * 10) - 5);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("Положительные элементы главной диагонали квадратной матрицы: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j && array[i][j] > 0) {
                    count++;
                    System.out.print(array[i][j] + ", ");
                }
            }
        }
        if (count == 0)
            System.out.print("Отсутствуют.");
    }
}