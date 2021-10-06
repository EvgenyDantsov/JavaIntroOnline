package com.evgeny.unit.arrayArray;

//Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.

import java.util.Scanner;

public class TaskTwoArray {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер квадратной матрицы: ");
        n = in.nextInt();
        int[][] array=new int[n][n];
        System.out.println("Array["+n+"]["+n+"]: ");
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++)
            {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Элементы стоящие на диагонали: ");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i][i]+" ");
        }
    }
}
