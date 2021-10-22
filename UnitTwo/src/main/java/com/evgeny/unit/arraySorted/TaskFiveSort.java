package com.evgeny.unit.arraySorted;

//Сортировка вставками. Дана последовательность чисел a1,a2,...,an. Требуется переставить числа в порядке
//возрастания. Делается это следующим образом. Пусть a1,a2,...,ai - упорядоченная последовательность, т. е.
//a1<=a2<=...<=an. Берется следующее число a(i+1) и вставляется в последовательность так, чтобы новая
//последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i+1 до n
//не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
//с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.

import java.util.Scanner;

public class TaskFiveSort {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        n = in.nextInt();
        System.out.print("Array: ");
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        sort(array);
        System.out.print("\nОтсортированный вставками Array: ");
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }

    public static int binarySearch(int[] array, int start, int end, int elem) {
        int mid = start + (end - start) / 2;
        if (elem <= array[start]) {
            return -1;
        }
        if (start >= end || elem > array[end]) {
            return end;
        }
        if (array[mid] < elem && elem <= array[mid + 1]) {
            return mid;
        }
        if (array[mid] > elem) {
            return binarySearch(array, start, mid - 1, elem);
        }
        return binarySearch(array, mid + 1, end, elem);
    }

    public static void sort(int[] array) {
        int i = 0;
        int n;
        int temp;
        while (i < array.length && array[i] < array[i + 1]) {
            if (i < array.length - 2) {
                i++;
            } else break;
        }
        for (int j = i + 1; j < array.length; j++) {
            n = binarySearch(array, 0, j, array[j]);
            for (int k = j; k > n + 1; k--) {
                if (array[k] <= array[k - 1]) {
                    temp = array[k - 1];
                    array[k - 1] = array[k];
                    array[k] = temp;
                }
            }
        }
    }
}
