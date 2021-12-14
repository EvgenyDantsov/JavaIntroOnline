package com.evgeny.unit.arrayArray;

import java.util.Scanner;

//Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
//|1  1   1  ... 1 1 1|
//|2  2   2  ... 2 2 0|
//|3  3   3  ... 3 0 0|
//|...................|
//|n-1 n-1 0 ... 0 0 0|
//|n  0   0  ... 0 0 0|

public class TaskFiveArray {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите четный размер квадратной матрицы: ");
            n = in.nextInt();
        } while (n % 2 != 0);
        int[][] array = new int[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (n > j) {
                    array[i][j] = i + 1;
                } else array[i][j] = 0;
                System.out.print(array[i][j] + " ");
            }
            n--;
            System.out.println();
        }
    }
}