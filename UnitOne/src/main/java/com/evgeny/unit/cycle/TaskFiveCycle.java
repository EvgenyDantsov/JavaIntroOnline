package com.evgeny.unit.cycle;

// Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
//заданному е. Общий член ряда имеет вид: an=1/2^n+1/3^n.

import java.util.Scanner;

public class TaskFiveCycle {
    public static void main(String[] args) {
        double An, e, sum = 0;
        int n = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите e: ");
        e = in.nextDouble();
        An = (1 / Math.pow(2, 0) + 1 / Math.pow(3, 0));
        if (e > 0) {
            while (Math.abs(An) >= e) {
                n++;
                sum = sum + An;
                An = (1 / Math.pow(2, n)) + (1 / Math.pow(3, n));
            }
            if (n == 0) {
                System.out.println("Значение Аn изначально меньше e.");
            } else {
                System.out.println("Сумма членов ряда равна " + sum);
            }
        } else {
            System.out.println("Введено e<=0.");
        }
    }
}