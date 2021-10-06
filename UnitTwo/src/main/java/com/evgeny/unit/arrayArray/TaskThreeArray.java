package com.evgeny.unit.arrayArray;

//Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

import java.util.Scanner;

public class TaskThreeArray {
    public static void main(String[] args) {
        int n,k,p;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");
        n = in.nextInt();
        System.out.print("Введите номер стороки матрицы k от 1 до "+n+": ");
        k = in.nextInt();
        System.out.print("Введите номер столбца матрицы p от 1 до "+n+": ");
        p = in.nextInt();
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
        System.out.print("Вывод "+k+"-ой строки: ");
        for(int i=0;i<array.length;i++)
        {
                System.out.print(array[k-1][i]+" ");
        }
        System.out.println("\nВывод "+p+"-ого столбца: ");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i][p-1]+"\n");
        }
    }
}
