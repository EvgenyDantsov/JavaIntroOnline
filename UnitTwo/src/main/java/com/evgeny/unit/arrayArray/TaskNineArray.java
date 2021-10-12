package com.evgeny.unit.arrayArray;

//Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
//столбец содержит максимальную сумму.

import java.util.Scanner;

public class TaskNineArray {
    public static void main(String[] args) {
        int n = 3, sumMax = 0, numberColumn = 0;
        Scanner in = new Scanner(System.in);
        int[] sum = new int[n];
        int[][] array = new int[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
                sum[j] = sum[j] + array[i][j];

            }
            System.out.println();
        }
        for (int i = 0; i < sum.length; i++) {
            if (sumMax < sum[i]) {
                sumMax = sum[i];
                numberColumn = i + 1;
            }
        }
        System.out.println("Номер столбца с максимальной суммой: " + numberColumn);
    }
}
