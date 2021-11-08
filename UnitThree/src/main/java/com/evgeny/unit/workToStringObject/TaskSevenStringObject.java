package com.evgeny.unit.workToStringObject;

//Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
// Например, если было введено "abc cde def", то должно быть выведено "abcdef".

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskSevenStringObject {
    public static void main(String[] args) {
        String string, stringBlank="", stringOneChar="$1";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        string = in.nextLine();
        System.out.println(string);
       // System.out.println("boooody".Distinct().ToArray());

//        Pattern pattern = Pattern.compile("\\s"); //шаблон поиска (по символу "а")
//        Pattern patternDuplicate = Pattern.compile("/(.)\\1+/g");
//       // string = searchPattern(pattern, string, stringBlank);
//        string = searchPattern(patternDuplicate, string, stringOneChar);
//        System.out.println(string);
//    }
//    public static String searchPattern(Pattern pattern, String string, String stringReplacement){
//        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
//        StringBuffer stringBuffer = new StringBuffer();
//        while (matcher.find()) {
//            matcher.appendReplacement(stringBuffer, stringReplacement);
//        }
//        matcher.appendTail(stringBuffer);//производиться объединение и замена, добавляеться хвост строки
//        string = stringBuffer.toString();
//        return string;
    }
}
