package com.evgeny.unit.decompositionMethods;

//Дано натуральное число N.
// Написать метод(методы) для формирования массива, элементами которого являются цифры числа N.

import java.util.Scanner;

public class TaskTenDecomposition {
    public static void main(String[] args) {
        int N;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число N: ");
        N = in.nextInt();
        buildArray(N);
    }

    public static int sizeArray(int N) {
        int count = 0;
        while (N != 0) {
            N = N / 10;
            count++;
        }
        return count;
    }

    public static void buildArray(int N) {
        int size = sizeArray(N), temp;
        int[] array = new int[size];
        System.out.print("Сформированный массив с элементами числа " + N + ": ");
        for (int i = 0; i < array.length; i++) {
            temp = N % 10;
            array[i] = temp;
            N = N / 10;
            System.out.print(array[i] + " ");
        }
    }
}