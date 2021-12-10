package com.evgeny.unit;

import java.util.Arrays;
import java.util.Scanner;

public class Airlines {
    private Airline[] airline;
    private int count;
    Scanner in = new Scanner(System.in);

    public Airlines(Airline[] airline) {
        this.airline = airline;
        this.count = sizeAirline();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void menu() {
        CreateFile cf = new CreateFile();
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
                cf.serializationFile(airline);
                break;
            }
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    if (sizeAirline() != 0) {
                        if (sizeAirline() >= airline.length) {
                            airline = Arrays.copyOf(airline, airline.length * 2);
                        }
                        airline[sizeAirline()] = Airline.getAirline(in, sizeAirline() + 1);
                    } else {
                        airline[0] = Airline.getAirline(in, 1);
                    }
                    break;
                case 2:
                    System.out.print("Введите пункт назначения: ");
                    String destination = in.next();
                    printFlightDestination(destination);
                    break;
                case 3:
                    System.out.print("Введите день недели: ");
                    String daysOfTheWeek = in.next();
                    printFlightDaysOfTheWeek(daysOfTheWeek);
                    break;
                case 4:
                    System.out.print("Введите день недели: ");
                    String dayOfTheWeek = in.next();
                    System.out.print("Введите время вылета: ");
                    String timeFlight = in.next();
                    printFlightDaysOfTheWeekAndTimeDepartureMore(dayOfTheWeek, timeFlight);
                    break;
            }
        }
    }

    public int sizeAirline() {
        setCount(0);
        for (Airline value : airline) {
            if (value != null) {
                count++;
            }
        }
        return count;
    }

    public void printFlightDestination(String destination) {
        for (Airline value : airline) {
            if (value != null && value.getDestination().compareTo(destination) == 0) {
                System.out.print(value);
                System.out.println();
            }
        }
    }

    public void printFlightDaysOfTheWeek(String daysOfTheWeek) {
        for (Airline value : airline) {
            if (value != null && value.getDaysOfTheWeek().compareTo(daysOfTheWeek) == 0) {
                System.out.print(value);
                System.out.println();
            }
        }
    }

    public void printFlightDaysOfTheWeekAndTimeDepartureMore(String daysOfTheWeek, String timeDeparture) {
        String[] timeDepartureEnter = timeDeparture.split(":");
        String[] timeDepartureListAirline;
        for (Airline value : airline) {
            if (value != null) {
                timeDepartureListAirline = value.getTimeDeparture().split(":");
                if ((Integer.parseInt(timeDepartureEnter[0]) < Integer.parseInt(timeDepartureListAirline[0]) || Integer.parseInt(timeDepartureEnter[1]) < Integer.parseInt(timeDepartureListAirline[1])) &&
                        value.getDaysOfTheWeek().compareTo(daysOfTheWeek) == 0) {
                    System.out.print(value);
                    System.out.println();
                }
            }
        }
    }
}