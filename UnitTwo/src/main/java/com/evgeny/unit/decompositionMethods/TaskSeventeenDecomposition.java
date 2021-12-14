package com.evgeny.unit.decompositionMethods;

//Из заданного числа вычли сумму его цифр.
// Из результата вновь вычли сумму его цифр и т.д. Сколько таких действий надо произвести,
// чтобы получился нуль? Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class TaskSeventeenDecomposition {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число n: ");
        n = in.nextInt();
        searchNumberOfAction(n);
    }

    public static int sumDigitNumber(int number) {
        int sum = 0, temp;
        while (number > 0) {
            temp = number % 10;
            sum = sum + temp;
            number = number / 10;
        }
        return sum;
    }

    public static void searchNumberOfAction(int n) {
        int count = 0;
        while (n > 0) {
            n = n - sumDigitNumber(n);
            count++;
        }
        System.out.println("Количество операций необходимо, чтобы получился ноль: " + count);
    }
}