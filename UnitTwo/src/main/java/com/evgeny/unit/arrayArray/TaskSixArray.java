package com.evgeny.unit.arrayArray;

import java.util.Scanner;

//Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
//|1  1   1  ... 1 1 1|
//|0  1   1  ... 1 1 0|
//|0  0   1  ... 1 0 0|
//|...................|
//|0  1   1  ... 1 1 0|
//|1  1   1  ... 1 1 1|
public class TaskSixArray {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите четный размер квадратной матрицы: ");
            n = in.nextInt();
        }while (n%2!=0);
        int[][] array=new int[n][n];
        System.out.println("Array["+n+"]["+n+"]: ");
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++)
            {
                if(j<=n-i)
                {
                    array[i][j]=1;
                } else array[i][j]=0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
