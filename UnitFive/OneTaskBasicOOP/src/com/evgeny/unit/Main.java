package com.evgeny.unit;

//Создать объект класса Текстовый файл, используя классы Файл, Директория.
//Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the path to the file: ");
        TextFile textFile = new TextFile(in.nextLine());
        textFile.menu();
    }
}
