package com.evgeny.unit.oneArray;

//Дана  последовательность  целых  чисел a1,a2,...,an.
// Образовать  новую  последовательность,  выбросив  из исходной те члены, которые равны min(a1,a2,...,an).

import java.util.Scanner;

public class TaskEight {
    public static void main(String[] args) {
        int n;
        int min = 0, count = 0, j = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер последовательности: ");
        n = in.nextInt();
        int[] array = new int[n];
        System.out.print("Array[" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            min = array[0];
            if (min >= array[i]) {
                min = array[i];
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\nmin: " + min);
        for (int arr : array) {
            if (arr == min) {
                count++;
            }
        }
        int[] arrayNew = new int[n - count];
        for (int i = 0; i < array.length; i++) {
            if (array[i] != min) {
                arrayNew[j] = array[i];
                j++;
            }
        }
        System.out.print("ArrayNew[" + (n - count) + "]: ");
        for (int arr : arrayNew) {
            System.out.print(arr + " ");
        }
    }
}