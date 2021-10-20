package com.evgeny.unit.arraySorted;

//Сортировка выбором. Дана последовательность чисел a1<=a2<=...<=an .Требуется переставить элементы так,
//чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
//элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
//повторяется. Написать алгоритм сортировки выбором.

import java.util.Scanner;

public class TaskThreeSort {
    public static void main(String[] args) {
        int n, minIndex;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        n = in.nextInt();
        System.out.print("Array: ");
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            System.out.print(array[i] + " ");
        }
        System.out.println("\nСортировка выбором: \nArray:");
        for (int i = 0; i < array.length; i++) {
            minIndex = searchMin(array, i, n - 1);
            swap(array, i, minIndex);
            System.out.print(array[i] + " ");
        }
    }

    public static int searchMin(int[] array, int begin, int end) {
        int min = array[begin];
        int minIndex = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (array[i] < array[i + 1]) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
