package com.evgeny.unit.oneArray;

import java.util.Scanner;

//В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
// Если таких чисел несколько, то определить наименьшее из них.
public class TaskNine {
    public static void main(String[] args) {
        int n, min = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        int[] array = new int[n];
        System.out.print("Array[" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        min = searchMin(array);
        System.out.println("\nНаиболее часто встречающееся число: " + min);
    }

    public static int searchMin(final int[] n) {
        int maxCount = 0, tempMaxCountElement = 0;
        int min = n[0];
        int[] countElements = new int[10];

        for (int i = 0; i < n.length; i++) { //заполняем массив считающий количество встречающихся элементов
            countElements[n[i]]++;
            if (maxCount < countElements[n[i]]) {
                maxCount = countElements[n[i]];
            }
        }
        for (int i = 0; i < n.length; i++) {
            if (tempMaxCountElement == 0 && maxCount == countElements[n[i]]) { //находим первый элемент с максимальным количеством повторов
                min = n[i];
                tempMaxCountElement++;
            } else if (min > n[i] && tempMaxCountElement > 0 && maxCount == countElements[n[i]]) { // сравниваем если элементов повторяющихся с одинаковым количеством несколько находим из них наименьший
                min = n[i];
            }
        }
        return min;
    }
}