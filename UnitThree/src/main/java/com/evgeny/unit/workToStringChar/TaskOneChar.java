package com.evgeny.unit.workToStringChar;

//Дан массив названий переменных в camelCase.
// Преобразовать названия в snake_case.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskOneChar {
    public static void main(String[] args) {
        String[] strings = {"SamBaddon", "AnnaGordon", "RichBerchov"};
        Pattern pattern = Pattern.compile("\\B[A-Z]"); //шаблон поиска(не граница слова и любой из перечисленных символов в верхнем регистре)
        for (int i = 0; i < strings.length; i++) {
            Matcher matcher = pattern.matcher(strings[i]); //проводиться поиск в тексте по шаблону
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) { //поиск совпадений в тексте с шаблоном
                matcher.appendReplacement(stringBuffer, "_$0"); //производиться объединение и замену на нижнее подчеркивание
            }
            matcher.appendTail(stringBuffer); //производиться объединение и замена, добавляется хвост строки
            strings[i] = stringBuffer.toString().toLowerCase();
        }
        for (String str : strings) {
            System.out.println(str + " ");
        }
    }
}
