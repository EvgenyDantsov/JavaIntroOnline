package com.evgeny.unit.workToStringChar;

//Удалить в строке все лишние пробелы, то есть серии
// подряд идущих пробелов заменить на одиночные пробелы.
// Крайние пробелы в строке удалить.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskFiveChar {
    public static void main(String[] args) {
        String string = "   word      word     word";
        System.out.println(string);
        string.replace("[\\s]+","x");
        System.out.println(string);
        System.out.println("            Твой      текст           тут".replaceAll("[\\s]{2,}", " "));
    }
}
