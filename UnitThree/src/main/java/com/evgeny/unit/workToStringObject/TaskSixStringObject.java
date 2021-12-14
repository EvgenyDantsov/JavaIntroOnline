package com.evgeny.unit.workToStringObject;

//Из заданной строки получить новую, повторив каждый символ дважды.

public class TaskSixStringObject {
    public static void main(String[] args) {
        String string = "Привет мой дорогой друг. Я сейчас в другом городе. Как обзаведусь телефоном позвоню.";
        String stringNew = string.replaceAll(".", "$0$0"); // заменяем любой символ и повторяем его дважды
        System.out.println(stringNew);
    }
}