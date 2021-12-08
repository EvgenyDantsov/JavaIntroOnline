package com.evgeny.unit;

//Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы,
// set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив типа
// Airline, с подходящими конструкторами и методами. Задать критерии выбора данных и
// вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//        Найти и вывести:
//        a) список рейсов для заданного пункта назначения;
//        b) список рейсов для заданного дня недели;
//        c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean existsFile;
        String nameFile = "Airline.txt";
        LinkedList<Airline> listAirline = new LinkedList<Airline>();
        CreateFile cf = new CreateFile();
        existsFile = cf.SearchFile(nameFile);
        if (existsFile) {
            listAirline = cf.deserializationFile(listAirline, nameFile);
        }
        Scanner in = new Scanner(System.in);
        Airlines airlines = new Airlines(listAirline);
        while (true) {
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Выйти\n" +
                            "1. Добавить рейс\n" +
                            "2. Вывод списка рейсов для заданного пункта назначения\n" +
                            "3. Вывод списка рейсов для заданного дня недели\n" +
                            "4. Вывод списка рейсов для заданного дня недели, время вылета для которых больше заданного\n" +
                            "Введите номер пункта меню: ");
            int choice = in.nextInt();
            if (choice == 0) {
                cf.serializationFile(listAirline, nameFile);
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    Airline airline = Airline.getAirline(in);
                    listAirline.add(airline);
                    break;
                case 2:
                    System.out.print("Введите пункт назначения: ");
                    String destination = in.next();
                    airlines.printFlightDestination(destination);
                    break;
                case 3:
                    System.out.print("Введите день недели: ");
                    String daysOfTheWeek = in.next();
                    airlines.printFlightDaysOfTheWeek(daysOfTheWeek);
                    break;
                case 4:
                    System.out.print("Введите день недели: ");
                    String dayOfTheWeek = in.next();
                    System.out.print("Введите время вылета: ");
                    String timeFlight = in.next();
                    airlines.printFlightDaysOfTheWeekAndTimeDepartureMore(dayOfTheWeek, timeFlight);
                    break;
            }
        }
    }
}
