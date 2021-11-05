package com.evgeny.unit.workToStringObject;

//Проверить, является ли заданное слово палиндромом.

import java.util.Scanner;

public class TaskThreeStringObject {
    public static void main(String[] args) {
        String string;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово: ");
        string = in.nextLine();
        if (isPalindrome(string)) {
            System.out.println("Слово \"" + string + "\" является полиндромом.");
        } else System.out.println("Слово \"" + string + "\" не является полиндромом.");
    }

    public static boolean isPalindrome(String string) {
        int i = 0, j = string.length() - 1;
        while (j > i) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
