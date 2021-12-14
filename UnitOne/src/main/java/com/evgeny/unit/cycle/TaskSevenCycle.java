package com.evgeny.unit.cycle;

//Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
//m и n вводятся с клавиатуры.

import java.util.Scanner;

public class TaskSevenCycle {
    public static void main(String[] args) {
        int m, n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите m: ");
        m = in.nextInt();
        System.out.print("Введите n: ");
        n = in.nextInt();
        while (m <= n) {
            System.out.print(m + ": ");
            for (int i = 2; i < m - 1; i++) {
                if (m % i == 0) {
                    System.out.print(i + "; ");
                }
            }
            m = m + 1;
            System.out.println();
        }
    }
}