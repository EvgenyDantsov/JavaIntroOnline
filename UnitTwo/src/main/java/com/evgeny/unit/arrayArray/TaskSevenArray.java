package com.evgeny.unit.arrayArray;

//Сформировать квадратную матрицу порядка N по правилу: A[I,J]=sin((I^2-J^2)/N)
//и подсчитать количество положительных элементов в ней.

import java.util.Scanner;

public class TaskSevenArray {
    public static void main(String[] args) {
        int n, count = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер квадратной матрицы: ");
        n = in.nextInt();
        double[][] array = new double[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Math.sin((i * i - j * j) / n);
                if (array[i][j] > 0) {
                    count++;
                }
                System.out.format("%.2f", array[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Количество положительных элементов: " + count);
    }
}
