package com.evgeny.unit.oneArray;

// Даны действительные числа a1,a2,...,an. Найти max(a1+a2n,a2+a(2n-1),...,an+a(n+1)).

import java.util.Scanner;

public class TaskSeven {
    public static void main(String[] args) {
        int N;
        int sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер последовательности: ");
        N = in.nextInt();
        int[] array = new int[N];
        System.out.print("Array[" + N + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
    }
}
