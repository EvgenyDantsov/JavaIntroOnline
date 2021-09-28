package com.evgeny.unit.cycle;

//Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.

import java.util.HashSet;
import java.util.Scanner;

public class TaskEightCycle {
    public static void main(String[] args) {
        int oneNumber, twoNumber, lengthOneNumber, lenghtTwoNumber;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        oneNumber = in.nextInt();
        System.out.print("Введите второе целое число: ");
        twoNumber = in.nextInt();
        HashSet<Integer> number = new HashSet<>();
        System.out.print("Чифры входящие в запись чисел " + oneNumber + " и " + twoNumber + ": ");
        lengthOneNumber = (int) ((Math.log10(oneNumber) % 10) + 1);
        lenghtTwoNumber = (int) ((Math.log10(twoNumber) % 10) + 1);
        for (int i = 1; i <= lengthOneNumber; i++) {
            number.add(oneNumber % 10);
            oneNumber = oneNumber / 10;
        }
        for (int i = 1; i <= lenghtTwoNumber; i++) {
            number.add(twoNumber % 10);
            twoNumber = twoNumber / 10;
        }
        System.out.println(number);
    }
}
