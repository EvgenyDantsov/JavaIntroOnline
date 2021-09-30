package com.evgeny.unit.oneArray;

//Даны действительные числа а1,а2,..., аn.
// Поменять местами наибольший и наименьший элементы.

import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        int n, maxNumber = 0, minNumber = 0, temp;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер последовательности: ");
        n = in.nextInt();
        int[] array = new int[n];
        System.out.print("Array[" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
            if (array[i] > array[maxNumber]) {
                maxNumber = i;
            }
            if (array[i] < array[minNumber]) {
                minNumber = i;
            }
        }
        System.out.print("\nИзмененный Array[" + n + "]: ");
        temp = array[maxNumber];
        array[maxNumber] = array[minNumber];
        array[minNumber] = temp;
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }
}
