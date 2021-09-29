package com.evgeny.unit.oneArray;

import java.util.Scanner;

//Дана последовательность действительных чисел а1 ,а2 ,..., аn.
// Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.

public class TaskTwo
{
    public static void main(String[] args) {
        int N, count = 0, Z;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер последовательности: ");
        N = in.nextInt();
        System.out.print("Введите Z: ");
        Z = in.nextInt();
        int[] array = new int[N];
        System.out.print("Array[" + N + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 20);
            System.out.print(array[i] + " ");
        }
        System.out.print("\nПосле замены Array[" + N + "]: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i]>Z) {
                count++;
                array[i]=Z;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\nКоличество замен: "+count);
    }
}
