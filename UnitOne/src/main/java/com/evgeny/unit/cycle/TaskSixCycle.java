package com.evgeny.unit.cycle;

//Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.

public class TaskSixCycle {
    public static void main(String[] args) {
// Сознательно опущены первые три десятка символов:
// печатать там нечего - табуляции и переводы строк, непечатаемые символы одним словом.
        for (int i = 32; i <= 255; i++) {
            System.out.println("Число: " + i + " Символ: " + (char) i);
        }
    }
}