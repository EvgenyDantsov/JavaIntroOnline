package com.evgeny.unit.decompositionMethods;

//Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
// элементами которого являются числа, сумма цифр которых равна К и которые не большее N.

import java.util.Scanner;

public class TaskTwelveDecomposition {
    public static void main(String[] args) {
        int K, N, count = 0;
        Scanner in = new Scanner(System.in);
        do {
            if (count > 0) {
                System.out.println("Введены некоректные данные!");
            }
            System.out.print("Введите натуральное число K: ");
            K = in.nextInt();
            System.out.print("Введите натуральное число N: ");
            N = in.nextInt();
            count++;
        } while (K > N);
        int[] array = new int[5];
        addArray(array, K, N);
    }

    public static void addArray(int[] array, int K, int N) {
        for (int i = 0; i < array.length; i++) {
            array[i] = searchValue(K, N);
            System.out.print(array[i] + " ");
        }
    }

    public static int searchValue(int K, int N) {
        int value, temp, sum = 0;
        value = (int) (Math.random() * N) + 1;
        temp = value;
        while (temp != 0) {
            sum = sum + temp % 10;
            temp = temp / 10;
        }
        if (sum == K) {
            return value;
        }
        return searchValue(K, N);
    }
}
