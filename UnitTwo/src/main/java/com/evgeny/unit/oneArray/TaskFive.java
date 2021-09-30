package com.evgeny.unit.oneArray;

//Даны целые числа а1,а2 ,..., аn.
// Вывести на печать только те числа, для которых аi> i.

import java.util.Scanner;

public class TaskFive {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер последовательности: ");
        n = in.nextInt();
        int[] array = new int[n];
        System.out.print("Array[" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        System.out.print("\nЧисла для которых а[i]>i: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
