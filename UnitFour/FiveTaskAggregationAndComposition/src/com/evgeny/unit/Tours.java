package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tours {
    private List<Tour> tourList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Tours(List tourList) {
        this.tourList = tourList;
    }
    public void menu() {
//        CreateFile cf = new CreateFile();
//        while (true) {
//            System.out.print(
//                    "Выберете пункт меню:\n" +
//                            "0. Выйти\n" +
//                            "1. Добавить покупателя\n" +
//                            "2. Вывод покупателей в алфавитном порядке\n" +
//                            "3. Вывод покупателей с номером кредитной картой в заданном интервале\n" +
//                            "Введите номер пункта меню: ");
//            int choice = in.nextInt();
//            if (choice == 0) {
//                cf.serializationFile(customer);
//                break;
//            }
//            if (choice < 1 || choice > 3) {
//                System.out.println("выбран неправильный пункт меню, повторите ввод.");
//                continue;
//            }
//            switch (choice) {
//                case 1:
//                    if (sizeCustomer() != 0) {
//                        if (sizeCustomer() >= customer.length) {
//                            customer = Arrays.copyOf(customer, customer.length * 2);
//                        }
//                        customer[sizeCustomer()] = Customer.getCustomer(in, sizeCustomer() + 1);
//                    } else {
//                        customer[0] = Customer.getCustomer(in, 1);
//                    }
//                    break;
//                case 2:
//                    sortByName();
//                    print();
//                    break;
//                case 3:
//                    System.out.print("Введи диапазон кредитных карт\n");
//                    System.out.print("От: ");
//                    String from = in.next();
//                    System.out.print("До: ");
//                    String to = in.next();
//                    printIfCardIn(from, to);
//                    break;
//            }
//        }
    }
}
