package com.evgeny.unit.arraySorted;

//Пусть даны две неубывающие последовательности действительных чисел a1<=a2<=...<=an и b1<=b2<=...<=bm.
//Требуется указать те места, на которые нужно вставлять элементы последовательности
// b1<=b2<=...<=bm в первую последовательность так, чтобы новая последовательность
// оставалась возрастающей.

import java.util.Scanner;

public class TaskSevenSort {
    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        n = in.nextInt();
        System.out.print("Введите натуральное число m: ");
        m = in.nextInt();
        System.out.print("ArrayOne: ");
        int[] arrayOne = new int[n];
        randomArray(arrayOne, n);
        System.out.print("ArrayTwo: ");
        int[] arrayTwo = new int[m];
        randomArray(arrayTwo, m);
        int[] arrayPlaceTwoToOne = new int[m];
        searchPlace(arrayOne, arrayTwo, arrayPlaceTwoToOne);
    }

    public static void randomArray(int[] array, int size) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + size;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void searchPlace(int[] arrayOne, int[] arrayTwo, int[] arrayPlaceTwoToOne) {
        int indexOne = 0, index = 0, count = 0;
        for (int j = 0; j < arrayTwo.length; j++) {
            if (arrayOne.length > indexOne) {
                if (arrayOne[indexOne] == arrayTwo[index]) {
                    arrayPlaceTwoToOne[index] = j + count;
                    indexOne++;
                    index++;
                    count++;
                } else if (arrayOne[indexOne] > arrayTwo[index]) {
                    arrayPlaceTwoToOne[j] = index + count;
                    index++;
                } else {
                    indexOne++;
                    count++;
                    j--;
                }
            } else {
                arrayPlaceTwoToOne[index] = j + count;
                index++;
            }
        }
        System.out.println("С учетом количества сделанных вставок " + "\nэлементы второго массива надо расположить "
                + "\nна следующих позициях первого массива: ");
        for (int arr : arrayPlaceTwoToOne) {
            System.out.print(arr + " ");
        }
    }
}