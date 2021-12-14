package com.evgeny.unit.workToStringChar;

//В строке найти количество чисел.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFourChar {
    public static void main(String[] args) {
        int count = 0;
        String string = "Word 12 and 24. Birthday 26.11.2020. Cost 127 dollars. 15 225. 587ds 123s456s78s90";
        Pattern pattern = Pattern.compile("\\d+"); //шаблон поиска (цифровой символ один или более раз)
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        while (matcher.find()) { //поиск совпадений в тексте с шаблоном
            count++;
        }
        System.out.println(string);
        System.out.println("Количество чисел в строке: " + count);
    }
}