package com.evgeny.unit.workToStringObject;

//Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
// Учитывать только английские буквы.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskNineStringObject {
    public static void main(String[] args) {
        String string;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        string = in.nextLine();
        System.out.println(string);
        Pattern lowPattern = Pattern.compile("[a-z]"); //шаблон поиска (символы английского языка в нижнем регистре)
        Pattern upperPattern = Pattern.compile("[A-Z]"); //шаблон поиска (символы английского языка в верхнем регистре)
        System.out.println("Количество строчных (маленьких) букв: " + countLetter(string, lowPattern) +
                "\nКоличество прописных (больших) букв: " + countLetter(string, upperPattern));
    }

    public static int countLetter(String string, Pattern pattern) {
        int count = 0;
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
