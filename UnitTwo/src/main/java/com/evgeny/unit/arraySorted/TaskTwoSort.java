package com.evgeny.unit.arraySorted;

//Даны две последовательности a1<=a2<=...<=an и b1<=b2<=...<=bm. Образовать из них новую последовательность
//чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class TaskTwoSort {
    public static void main(String[] args) {
        int n, m, i = 0, j = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        n = in.nextInt();
        System.out.print("Введите натуральное число m: ");
        m = in.nextInt();
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[m];
        int[] arrayGeneral = new int[arrayOne.length + arrayTwo.length];
        System.out.print("ArrayOne: ");
        printArray(arrayOne, n);
        System.out.print("ArrayTwo: ");
        printArray(arrayTwo, m);
        System.out.print("ArrayGeneral: ");
        for (int k = 0; k < arrayGeneral.length; k++) {
            if (j >= arrayTwo.length || i < arrayOne.length && arrayOne[i] <= arrayTwo[j]) {
                arrayGeneral[k] = arrayOne[i];
                i++;
            } else if (j < arrayTwo.length) {
                arrayGeneral[k] = arrayTwo[j];
                j++;
            } else {
                arrayGeneral[k] = arrayOne[i];
                i++;
            }
            System.out.print(arrayGeneral[k] + " ");
        }
    }

    public static void printArray(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * x;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
