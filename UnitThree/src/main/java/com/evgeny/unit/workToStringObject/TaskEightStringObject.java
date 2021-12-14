package com.evgeny.unit.workToStringObject;

//Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
// Случай, когда самых длинных слов может быть несколько, не обрабатывать.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskEightStringObject {
    public static void main(String[] args) {
        int maxWord = 0;
        String string, stringMaxWord = "";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        string = in.nextLine();
        System.out.println(string);
        String[] words = string.split(" ");
        for (String word : words) {
            if (word.length() > maxWord) {
                maxWord = word.length();
                stringMaxWord = word;
            }
        }
        System.out.println("Самое длинное слово в введенной строке: " + stringMaxWord);
    }
}