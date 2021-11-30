package com.evgeny.unit;

//Создайте класс Train, содержащий поля: название пункта назначения, номер поезда,
// время отправления. Создайте данные в массив из пяти элементов типа Train,
// добавьте возможность сортировки элементов массива по номерам поездов.
// Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
// Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми
// пунктами назначения должны быть упорядочены по времени отправления.

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 5, valueMenu;
        Train trains[] = new Train[n];
        trains[0] = new Train("Moscow", 256, "12:42");
        trains[1] = new Train("Moscow", 243, "12:45");
        trains[2] = new Train("Minsk", 45, "23:08");
        trains[3] = new Train("Moscow", 49, "12:42");
        trains[4] = new Train("Minsk", 111, "05:44");
        while (true) {
            System.out.println(
                    "Выберете пункт меню:" + "\n" +
                            "1. Сортировка по номерам поездов" + "\n" +
                            "2. Вывод информации о поезде по номеру поезда" + "\n" +
                            "3. Сортировка по пункту назначения" + "\n" +
                            "4. выход" + "\n"
            );
            System.out.print("Ваш выбор пункта меню: ");
            valueMenu = in.nextInt();
            if (valueMenu == 4)
                break;
            if (valueMenu < 1 || valueMenu > 4) {
                System.out.println("Выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (valueMenu) {
                case 1:
                    Arrays.sort(trains, new Train.ByNumberComparator());
                    for (int i = 0; i < trains.length; ++i) {
                        System.out.print(i + " ");
                        trains[i].print();
                    }
                    break;
                case 2:
                    System.out.println("Введите номер поезда: ");
                    int numberTrain = in.nextInt();
                    for (int i = 0; i < trains.length; i++) {
                        if (trains[i].getNumberTrain() == numberTrain) {
                            trains[i].print();
                        }
                    }
                    break;
                case 3:
                    Arrays.sort(trains, new Train.ByDestinationAndTimeComparator());
                    for (int i = 0; i < trains.length; ++i) {
                        trains[i].print();
                    }
                    break;
            }
        }
    }
}
