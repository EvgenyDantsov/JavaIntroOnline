package com.evgeny.unit.oneArray;

import java.util.Scanner;

//В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
// Если таких чисел несколько, то определить наименьшее из них.
public class TaskNine {
    public static void main(String[] args) {
        int n;
        int sum = 0, max, temp;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        int[] array = new int[n];
        System.out.print("Array[" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
    }
}
