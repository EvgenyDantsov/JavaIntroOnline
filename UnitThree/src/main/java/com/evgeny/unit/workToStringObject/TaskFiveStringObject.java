package com.evgeny.unit.workToStringObject;

//Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFiveStringObject {
    public static void main(String[] args) {
        int count = 0;
        String string = "Привет мама и папа, я сегодня выпил кампот и скушал всю кашу с колбасой. аа";
        System.out.println("Исходная строка: " + string);
        Pattern pattern = Pattern.compile("а"); //шаблон поиска (по символу "а")
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        while (matcher.find()) {
            count++;
        }
        System.out.println("Буква \"а\" встречается: " + count + " раз.");
    }
}