package com.evgeny.unit.arraySorted;

//Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
//Делается это следующим образом: сравниваются два соседних элемента ai и a(i+1). Если ai<=a(i+1),
// то продвигаются на один элемент вперед. Если ai>a(i+1), то производится перестановка
// и сдвигаются на один элемент назад. Составить алгоритм этой сортировки.

import java.util.Scanner;

public class TaskSixSort {
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
        sortShell(array, n);
        System.out.print("\nОтсортированный алгоритмом Шелла Array: ");
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }

    public static void sortShell(int[] array, int n) {
        for (int step = n / 2; step > 0; step = step / 2) {
            for (int i = step; i < n; i++) {
                for (int j = i - step; j >= 0 && array[j] > array[j + step]; j = j - step) {
                    int x = array[j];
                    array[j] = array[j + step];
                    array[j + step] = x;
                }
            }
        }
    }
}


