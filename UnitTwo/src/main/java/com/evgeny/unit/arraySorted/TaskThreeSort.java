package com.evgeny.unit.arraySorted;

//Сортировка выбором. Дана последовательность чисел a1<=a2<=...<=an .Требуется переставить элементы так,
//чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
//элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
//повторяется. Написать алгоритм сортировки выбором.

import java.util.Scanner;

public class TaskThreeSort {
    public static void main(String[] args) {
        int n, maxIndex;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        n = in.nextInt();
        System.out.print("Array: ");
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            System.out.print(array[i] + " ");
        }
        System.out.print("\nСортировка выбором: \nArray: ");
        for (int i = 0; i < array.length; i++) {
            maxIndex = searchMax(array, i, n - 1);
            swap(array, i, maxIndex);
            System.out.print(array[i] + " ");
        }
    }

    public static int searchMax(int[] array, int begin, int end) {
        int maxIndex = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[i + 1]) {
                maxIndex = i + 1;
            }
        }
        return maxIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
