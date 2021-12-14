package com.evgeny.unit.arraySorted;

//Даны дроби p1/q1,p2/q2,...,pn/qn (pi, qi - натуральные). Составить программу, которая приводит эти дроби к общему
//знаменателю и упорядочивает их в порядке возрастания.

import java.util.Scanner;

public class TaskEightSort {
    public static void main(String[] args) {
        int n, generalNok;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите натуральное число n: ");
        n = in.nextInt();
        System.out.print("Дроби: ");
        int[] numerator = new int[n];
        int[] denominator = new int[n];
        randomValue(numerator, denominator);
        generalNok = generalNokForAllDenominators(denominator);
        for (int i = 0; i < numerator.length; i++) {
            numerator[i] = numerator[i] * (generalNok / denominator[i]);
            denominator[i] = generalNok;
        }
        sortFraction(numerator);
        System.out.print("Упорядоченные дроби: ");
        for (int i = 0; i < numerator.length; i++) {
            System.out.print(numerator[i] + "/" + denominator[i] + " ");
        }

    }

    public static void randomValue(int[] numerator, int[] denominator) {
        for (int i = 0; i < numerator.length; i++) {
            numerator[i] = (int) (Math.random() * 10);
            denominator[i] = (int) (Math.random() * 10);
            System.out.print(numerator[i] + "/" + denominator[i] + " ");
        }
        System.out.println();
    }

    public static int nod(int a, int b) {
        return b == 0 ? a : nod(b, a % b);
    }

    public static int nok(int a, int b) {
        return a * b / nod(a, b);
    }

    public static int generalNokForAllDenominators(int[] denominator) {
        int b = 0;
        for (int i = 0; i < denominator.length - 1; i++) {
            if (b == 0) {
                b = nok(denominator[i], denominator[i + 1]);
            } else {
                b = nok(b, denominator[i + 1]);
            }
        }
        return b;
    }

    public static void sortFraction(int[] numerator) {
        int temp;
        for (int i = 0; i < numerator.length; i++) {
            for (int j = i + 1; j < numerator.length; j++) {
                if (numerator[i] > numerator[j]) {
                    temp = numerator[j];
                    numerator[j] = numerator[i];
                    numerator[i] = temp;
                }
            }
        }
    }
}