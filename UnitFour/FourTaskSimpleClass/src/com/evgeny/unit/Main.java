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
        Scanner scanner = new Scanner(System.in);
        int n = 5, value;
        Train trains[] = new Train[n];
        trains[0] = new Train("Msk", 123, "12:42");
        trains[1] = new Train("Msk", 124, "12:45");
        trains[2] = new Train("Spb", 34, "23:08");
        trains[3] = new Train("Msk", 33, "12:42");
        trains[4] = new Train("Spb", 156, "05:44");
        while (true) {
            System.out.println(
                    "Выберете пункт меню:" + "\n" +
                            "1. Сортировка по номерам поездов" + "\n" +
                            "2. Вывод информации о поезде по номеру" + "\n" +
                            "3. Сортировка по пункту назначения" + "\n" +
                            "4. вывод всех поездов" + "\n" +
                            "5. выход" + "\n"
            );
            value = scanner.nextInt();
            if (value == 5)
                break;
            if (value < 1 || value > 5) {
                System.out.println("Выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (value) {
                case 1:
                    Arrays.sort(trains, new Train.ByNumberComparator());
                    for (int i = 0; i < trains.length; ++i) {
                        System.out.print(i + " ");
                        trains[i].print();
                    }
                    break;
                case 2:
                    System.out.println("Введите номер поезда: ");
                    int pos = scanner.nextInt();
                    for (int i = 0; i < trains.length; i++) {
                        if (trains[i].getNumberTrain() == pos) {
                            trains[i].print();
                        }
                    }
                    break;
                case 3:
                    Arrays.sort(trains, new Train.ByDestinationAndTimeComparator());
                    break;
                case 4:
                    for (int i = 0; i < trains.length; ++i) {
                        System.out.print(i + " ");
                        trains[i].print();
                    }
                    break;
            }
        }
    }
}
