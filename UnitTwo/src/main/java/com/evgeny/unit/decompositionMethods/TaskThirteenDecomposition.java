package com.evgeny.unit.decompositionMethods;

//Два простых числа называются «близнецами», если они отличаются друг от друга на 2
// (например, 41 и 43). Найти и напечатать все пары «близнецов» из отрезка [n,2n],
// где n - заданное натуральное число больше 2. Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class TaskThirteenDecomposition {
    public static void main(String[] args) {
        int n, count = 0;
        Scanner in = new Scanner(System.in);
        do {
            if (count > 0) {
                System.out.println("Число n должно быть больше 2.");
            }
            System.out.print("Введите натуральное число n: ");
            n = in.nextInt();
        } while (n < 2);
        System.out.print("Пары близнецов на отрезке [" + n + ", " + 2 * n + "]: ");
        searchPrimeTwins(n);
    }

    public static void searchPrimeTwins(int n) {
        for (int i = n; i <= 2 * n; i++) {
            if (searchPrime(i) && searchPrime(i + 2) && (2 * n) >= (i + 2)) {
                System.out.print("(" + i + ", " + (i + 2) + ") ");
            }
        }
    }

    public static boolean searchPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}