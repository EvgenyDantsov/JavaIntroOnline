package com.evgeny.unit.workToStringChar;

//Удалить в строке все лишние пробелы, то есть серии
// подряд идущих пробелов заменить на одиночные пробелы.
// Крайние пробелы в строке удалить.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFiveChar {
    public static void main(String[] args) {
        String string = "     World  it's       beautiful.    This   house very    expensive.    ";
        System.out.println(string);
        Pattern pattern = Pattern.compile("\\s+"); //шаблон поиска (символ пробела, один или более раз)
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, " "); //производиться объединение и замену на одиночный пробел
        }
        matcher.appendTail(stringBuffer);//производиться объединение и замена, добавляеться хвост строки
        string = stringBuffer
                .toString()
                .trim();
        System.out.println(string);
    }
}