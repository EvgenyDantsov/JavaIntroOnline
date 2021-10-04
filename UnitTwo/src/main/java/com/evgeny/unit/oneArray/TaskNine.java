package com.evgeny.unit.oneArray;

import java.util.Scanner;

//В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
// Если таких чисел несколько, то определить наименьшее из них.
public class TaskNine {
    public static void main(String[] args) {
        int n;
        int sum = 0, min=0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        int[] array = new int[n];
        System.out.print("Array[" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        min=searchMin(array);
        System.out.println("\nНаиболее часто встречающееся число: "+min);
    }

    public static int searchMin(final int[] n) {
        int maxCounts = 0;
        int min=n[0];
        int[] countElements = new int[n.length];

        for (int i=0; i < n.length; i++) {
            countElements[n[i]]++;
            if (maxCounts < countElements[n[i]]) {
                maxCounts = countElements[n[i]];
            }
        }
        for(int i=0;i<n.length;i++)
        {
            if(maxCounts==countElements[n[i]]){
                if(min>n[i])
                {
                    min=n[i];
                }
            }
        }
        return min;
    }
}