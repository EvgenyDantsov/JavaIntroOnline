package com.evgeny.unit.decompositionMethods;

//Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

import java.util.Scanner;

public class TaskElevenDecomposition {
    public static void main(String[] args) {
        int oneNumber, twoNumber;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        oneNumber = in.nextInt();
        System.out.print("Введите второе число: ");
        twoNumber = in.nextInt();
        numberMoreDigit(oneNumber, twoNumber);
    }

    public static void numberMoreDigit(int oneNumber, int twoNumber) {
        int countOne, countTwo;
        countOne = countDigit(oneNumber);
        countTwo = countDigit(twoNumber);
        if (countOne < countTwo) {
            System.out.println("У второго числа цифр больше.");
        } else if (countOne == countTwo) {
            System.out.println("Чифр у двух чисел одинаково.");
        } else System.out.println("У первого числа цифр больше.");
    }

    public static int countDigit(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        return count;
    }
}