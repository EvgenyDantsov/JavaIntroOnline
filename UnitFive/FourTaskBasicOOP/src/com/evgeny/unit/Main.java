package com.evgeny.unit;

//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.
//Дракон и его сокровища. Создать программу, позволяющую обрабатывать
// сведения о 100 сокровищах в пещере дракона. Реализовать возможность просмотра сокровищ,
// выбора самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.

import com.evgeny.unit.dragon.CaveDragon;
import com.evgeny.unit.treasure.CreateFile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CreateFile cf = new CreateFile();
        Scanner in = new Scanner(System.in);
        CaveDragon dragon = new CaveDragon();
        dragon.setTreasureList(cf.deserializationFile(dragon.getTreasureList()));
        int number = 0;
        do {
            System.out.print("0. Exit\n" +
                    "1. Treasure list\n" +
                    "2. Finding the most expensive treasure\n" +
                    "3. Find a treasure for a given amount\n");
            System.out.print("Select: ");
            number = in.nextInt();
            switch (number) {
                case 0:
                    break;
                case 1:
                    dragon.showTreasure();
                    break;
                case 2:
                    dragon.greatestTreasure();
                    break;
                case 3:
                    System.out.print("Enter: ");
                    double sum = in.nextDouble();
                    dragon.chooseTreasuresAmount(sum);
                    break;
                default:
                    System.out.println("Invalid value");
                    break;
            }
        } while (number != 0);
    }
}