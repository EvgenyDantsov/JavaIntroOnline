package com.evgeny.unit.arrayArray;

import java.util.Scanner;

//Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
//|1  2   3  ... n|
//|n n-1 n-2 ... 1|
//|1  2   3  ... n|
//|n n-1 n-2 ... 1|
//|...............|
//|n n-1 n-2 ... 1|
public class TaskFourArray {
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
               if(i%2==0)
               {
                   array[i][j]=j+1;
               }else array[i][j]=n-j;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
