package com.evgeny.unit.arrayArray;

//Отсотрировать стобцы матрицы по возрастанию и убыванию значений элементов.

import java.util.Scanner;

public class TaskThirteenArray {
    public static void main(String[] args) {
        int n = 5;
        Scanner in = new Scanner(System.in);
        int[][] array = new int[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) ((Math.random() * 10));
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        sortUp(array);
        sortDown(array);
    }

    public static void sortUp(int[][] array) {
        int temp;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int z = 0; z < array.length - 1; z++) {
                    if (array[z][i] > array[z + 1][i]) {
                        temp = array[z][i];
                        array[z][i] = array[z + 1][i];
                        array[z + 1][i] = temp;
                    }
                }
            }
        }
        System.out.println("По возрастанию: ");
        printArray(array);
    }

    public static void sortDown(int[][] array) {
        int temp;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int z = 0; z < array.length - 1; z++) {
                    if (array[z][i] < array[z + 1][i]) {
                        temp = array[z][i];
                        array[z][i] = array[z + 1][i];
                        array[z + 1][i] = temp;
                    }
                }
            }
        }
        System.out.println("По убыванию: ");
        printArray(array);
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}