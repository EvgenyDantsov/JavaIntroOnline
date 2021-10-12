package com.evgeny.unit.arrayArray;

//Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
//единиц равно номеру столбца.

import java.util.Scanner;

public class TaskFourteenArray {
    public static void main(String[] args) {
        int m, n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите m: ");
        m = in.nextInt();
        System.out.print("Введите n: ");
        n = in.nextInt();
        if (m<n)
        {
            System.out.println("Вы ввели m < n.");
        }else {
            int[][] array = new int[m][n];
            System.out.println("Array[" + m + "][" + n + "]: ");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j >= i) array[i][j] = 1;
                    else array[i][j] = 0;
                    System.out.print(array[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
