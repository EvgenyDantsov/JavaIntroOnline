package com.evgeny.unit.cycle;

//Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.

import java.util.Scanner;

public class TaskEightCycle {
    public static void main(String[] args) {
        int oneNumber, twoNumber, lengthOneNumber, lengthTwoNumber, count = 0, temp, status = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите первое целое число: ");
        oneNumber = in.nextInt();
        System.out.print("Введите второе целое число: ");
        twoNumber = in.nextInt();
        lengthOneNumber = (int) ((Math.log10(oneNumber) % 10) + 1);
        lengthTwoNumber = (int) ((Math.log10(twoNumber) % 10) + 1);
        int[] number = new int[lengthOneNumber + lengthTwoNumber];
        System.out.print("Чифры входящие в запись чисел " + oneNumber + " и " + twoNumber + ": ");
        for (int i = 0; i < lengthOneNumber; i++) {
            number[i] = oneNumber % 10;
            oneNumber = oneNumber / 10;
            count++;
        }
        for (int i = lengthOneNumber; i < number.length; i++) {
            temp = twoNumber % 10;
            for (int j = 0; j < lengthOneNumber; j++) {
                if (number[j] != temp) {
                    status++;
                }
            }
            if (status == lengthTwoNumber) {
                number[i] = twoNumber % 10;
                twoNumber = twoNumber / 10;
                count++;
                status = 0;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(number[i] + " ");
        }
    }
}