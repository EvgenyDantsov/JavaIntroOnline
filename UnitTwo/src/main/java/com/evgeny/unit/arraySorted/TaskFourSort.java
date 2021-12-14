package com.evgeny.unit.arraySorted;

import java.util.Scanner;

//Сортировка обменами. Дана последовательность чисел a1<=a2<=...<=an .Требуется переставить числа в
//порядке возрастания. Для этого сравниваются два соседних числа ai и a(i+1) . Если ai>a(i+1), то делается
//перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
//Составить алгоритм сортировки, подсчитывая при этом количества перестановок.

public class TaskFourSort {
    public static void main(String[] args) {
        int n, temp, count = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        n = in.nextInt();
        System.out.print("Array: ");
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = n - 1;                    //задал убывающую последовательность, чтобы провести сортировку обменом.
            n--;
            System.out.print(array[i] + " ");
        }
        System.out.print("\nСортировка обменами: \nArray: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\nКоличество перестановок: " + count);
    }
}