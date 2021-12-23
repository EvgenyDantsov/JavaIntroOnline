package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tours {
    private int idGeneratorTour;
    private List<Tour> tourList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Tours(List tourList) {
        this.tourList = tourList;
    }

    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }

    public int idGeneratorTour() {
        if (getTourList().size() > 0) {
            idGeneratorTour = getTourList().size() + 1;
        } else idGeneratorTour = 1;
        return idGeneratorTour;
    }

    public int getIdGeneratorTour() {
        return idGeneratorTour;
    }

    public void setIdGeneratorTour(int idGeneratorTour) {
        this.idGeneratorTour = idGeneratorTour;
    }

    public void menu() {
       CreateFile cf = new CreateFile();
        while (true) {
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Выйти\n" +
                            "1. Добавить тур\n" +
                            "2. Вывод туров соответствующие критериям пользователя\n" +
                            "Введите номер пункта меню: ");
            int choice = in.nextInt();
            if (choice == 0) {
                cf.serializationFile(tourList);
                break;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    tourList.add( Tour.getTour(in, idGeneratorTour()));
//                    if (sizeCustomer() != 0) {
//                        if (sizeCustomer() >= customer.length) {
//                            customer = Arrays.copyOf(customer, customer.length * 2);
//                        }
//                        customer[sizeCustomer()] = Customer.getCustomer(in, sizeCustomer() + 1);
//                    } else {
//                        customer[0] = Customer.getCustomer(in, 1);
//                    }
                    break;
                case 2:
                    for (Tour tour : tourList)
                    {
                        System.out.println(tour.toString());
                    }
                    break;
                case 3:

                    break;
            }
        }
    }
}
