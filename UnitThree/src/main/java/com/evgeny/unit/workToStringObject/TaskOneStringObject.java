package com.evgeny.unit.workToStringObject;

//Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskOneStringObject {
    public static void main(String[] args) {
        int maxBlank = 0;
        String string = "  Search   blank:     fiveBlank or        eightBlank.  ";
        System.out.println(string);
        Pattern pattern = Pattern.compile("\\s+"); //шаблон поиска (символ пробела, один или более раз)
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        while (matcher.find()) {
            String subString = matcher.group(); //возвращает подстроку, которая совпала с шаблоном поиска
            if (subString.length() > maxBlank) {
                maxBlank = subString.length();
            }
        }
        System.out.println("Наибольшее количество подряд идущих пробелов: " + maxBlank);
    }
}
