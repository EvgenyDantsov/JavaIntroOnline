package com.evgeny.unit.workToStringObject;

//С помощью функции копирования и операции конкатенации
// составить из частей слова “информатика” слово “торт”.

public class TaskFourStringObject {
    public static void main(String[] args) {
        String string = "информатика", stringCake;
        StringBuilder stringBuilder = new StringBuilder(string);
        stringCake = stringBuilder.substring(7, 8) + stringBuilder.substring(3, 5) + stringBuilder.substring(7, 8);
        System.out.println("Составление из частей слова \"" + string + "\"" +
                " слово \"торт\": " + stringCake);
    }
}