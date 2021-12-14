package com.evgeny.unit.workToStringObject;

//В строке вставить после каждого символа 'a' символ 'b'.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskTwoStringObject {
    public static void main(String[] args) {
        String string = "Bay, be ale to, asent, aort, aility, aout, asolutely";
        System.out.println("Исходная строка: " + string);
        Pattern pattern = Pattern.compile("a"); //шаблон поиска (по символу "а")
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "ab");
        }
        matcher.appendTail(stringBuffer);//производиться объединение и замена, добавляеться хвост строки
        string = stringBuffer.toString();
        System.out.println("Исправленная строка: " + string);
    }
}