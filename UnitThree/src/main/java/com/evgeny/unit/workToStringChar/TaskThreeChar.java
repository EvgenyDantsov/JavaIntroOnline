package com.evgeny.unit.workToStringChar;

//В строке найти количество цифр.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskThreeChar {
    public static void main(String[] args) {
        int count = 0;
        String string = "Word 12 and 24. Birthday 26.11.2020. Cost 127 dollars.";
        Pattern pattern = Pattern.compile("\\d"); //шаблон поиска (цифровой символ)
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) { //поиск совпадений в тексте с шаблоном
            count++;
        }
        System.out.println(string);
        System.out.println("Количество цифр в строке: " + count);
    }
}
