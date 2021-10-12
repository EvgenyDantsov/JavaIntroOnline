package com.evgeny.unit.arrayArray;

//Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
//которых число 5 встречается три и более раз.

import java.util.Scanner;

public class TaskElevenArray {
    public static void main(String[] args) {
        int n = 10, m = 20, count = 0;
        Scanner in = new Scanner(System.in);
        int[] countRow = new int[n];
        int[][] array = new int[n][m];
        System.out.println("Array[" + n + "][" + m + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < m - 1; j++) {
                array[i][j] = (int) ((Math.random() * 15));
                System.out.print(array[i][j] + "\t");
                if (array[i][j] == 5) {
                    countRow[i]++;
                }
            }
            System.out.println();
        }
        System.out.print("Номера строк в которых число 5 встречаеться три и более раз: ");
        for (int i = 0; i < countRow.length; i++) {
            if (countRow[i] >= 3) {
                count++;
                System.out.print((i + 1) + " строка, ");
            }
        }
        if (count == 0) {
            System.out.print("таких строк нету.");
        }
    }
}
