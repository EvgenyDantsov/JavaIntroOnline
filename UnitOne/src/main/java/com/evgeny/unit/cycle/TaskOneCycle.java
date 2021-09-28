package com.evgeny.unit.cycle;

//Напишите программу, где пользователь вводит любое целое положительное число.
//А программа суммирует все числа от 1 до введенного пользователем числа.

import java.util.Scanner;

public class TaskOneCycle {
    public static void main(String[] args) {
        int value, sum = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое положительное число: ");
        value = in.nextInt();
        if (value > 0) {
            for (int i = 1; i <= value; i++) {
                sum = sum + i;
            }
            System.out.println("Сумма чисел от 1 до " + value + ". sum: " + sum);
        } else System.out.println("Введено отрицательное число!");
    }
}
