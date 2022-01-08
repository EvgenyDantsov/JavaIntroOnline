package com.evgeny.unit;

//Создать объект класса Текстовый файл, используя классы Файл, Директория.
//Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.

public class Main {

    public static void main(String[] args) {
        TextFile textFile = new TextFile();
        textFile.menu();
    }
}
