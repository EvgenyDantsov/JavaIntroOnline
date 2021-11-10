package com.evgeny.unit.workToStringObject;

//Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
// Например, если было введено "abc cde def", то должно быть выведено "abcdef".

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskSevenStringObject {
    public static void main(String[] args) {
        String string;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        string = in.nextLine();
        System.out.println(string);
        string = deleteBlank(string);
        System.out.println(searchDuplicates(string));
    }

    public static String searchDuplicates(String string) {
        if (string == null || string.length() < 2) {
            return string;
        }
        int position = 1;
        char[] charValue = string.toCharArray();
        for (int i = 1; i < string.length(); i++) {
            int j;
            for (j = 0; j < position; ++j) {
                if (charValue[i] == charValue[j]) {
                    break;
                }
            }
            if (j == position) {
                charValue[position] = charValue[i];
                ++position;
            } else {
                charValue[position] = 0;
                ++position;
            }
        }
        return getStringWithoutDuplicates(charValue);
    }

    public static String deleteBlank(String string) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "");
        }
        matcher.appendTail(stringBuffer);//производиться объединение и замена, добавляеться хвост строки
        return stringBuffer.toString();
    }

    public static String getStringWithoutDuplicates(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder(chars.length);
        for (char characters : chars) {
            if (characters != 0) {
                stringBuilder.append(characters);
            }
        }
        return stringBuilder.toString();
    }
}
