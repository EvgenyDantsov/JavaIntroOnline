package com.evgeny.unit.arrayArray;

//Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.

import java.util.Scanner;

public class TaskFifteenArray {
    public static void main(String[] args) {
        int n=5, maxElement=0;
            int[][] array = new int[n][n];
            System.out.println("Array[" + n + "][" + n + "]: ");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = (int) (Math.random() * 10);
                    System.out.print(array[i][j] + "\t");
                    if(array[i][j]>maxElement)
                    {
                        maxElement=array[i][j];
                    }
                }
                System.out.println();
            }
        System.out.println("\nЗаменены все нечетные элементы на "+maxElement+": ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j]%2!=0)
                {
                    array[i][j]=maxElement;
                }
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
            }
        }
