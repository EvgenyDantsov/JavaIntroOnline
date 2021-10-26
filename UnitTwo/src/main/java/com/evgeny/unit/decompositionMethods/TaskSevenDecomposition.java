package com.evgeny.unit.decompositionMethods;

//Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.

public class TaskSevenDecomposition {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 9; i += 2) {
            sum = sum + getFactorial(i);
        }
        System.out.println("Сумма факториалов всех нечетных чисел от 1 до 9: " + sum);
    }

    public static int getFactorial(int i) {
        if (i <= 1) {
            return 1;
        } else {
            return i * getFactorial(i - 1);
        }
    }
}
