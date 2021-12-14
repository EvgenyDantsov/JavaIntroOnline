package com.evgeny.unit.workToStringObject;

//Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
// восклицательным или вопросительным знаком. Определить количество предложений в строке X.

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskTenStringObject {
    public static void main(String[] args) {
        int count = 0;
        String string = "Привет, мой юный друг. Как твои дела? Я купил себе новую машину и она удивительная!" +
                "\nПриезжай на нее посмотреть. Напиши или позвони мне когда придешь! " +
                "\nЖду звонка. До скорой встречи.";
        System.out.println(string);
        Pattern pattern = Pattern.compile("\\?|\\.|!");
        Matcher matcher = pattern.matcher(string); //проводиться поиск в тексте по шаблону
        while (matcher.find()) {
            count++;
        }
        System.out.println("Количество предложений в строке: " + count);
    }
}