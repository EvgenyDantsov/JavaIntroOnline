package com.evgeny.unit;

import java.util.Arrays;
import java.util.Scanner;

public class Customers {
    private Customer[] customer;
    private int count;
    Scanner in = new Scanner(System.in);

    public Customers(Customer[] customer) {
        this.customer = customer;
        this.count = sizeCustomer();
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
                            "1. Добавить покупателя\n" +
                            "2. Вывод покупателей в алфавитном порядке\n" +
                            "3. Вывод покупателей с номером кредитной картой в заданном интервале\n" +
                            "Введите номер пункта меню: ");
            int choice = in.nextInt();
            if (choice == 0) {
                cf.serializationFile(customer);
                break;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    if (sizeCustomer() != 0) {
                        if (sizeCustomer() >= customer.length) {
                            customer = Arrays.copyOf(customer, customer.length * 2);
                        }
                        customer[sizeCustomer()] = Customer.getCustomer(in, sizeCustomer() + 1);
                    } else {
                        customer[0] = Customer.getCustomer(in, 1);
                    }
                    break;
                case 2:
                    sortByName();
                    print();
                    break;
                case 3:
                    System.out.print("Введи диапазон кредитных карт\n");
                    System.out.print("От: ");
                    String from = in.next();
                    System.out.print("До: ");
                    String to = in.next();
                    printIfCardIn(from, to);
                    break;
            }
        }
    }

    public int sizeCustomer() {
        setCount(0);
        for (Customer value : customer) {
            if (value != null) {
                count++;
            }
        }
        return count;
    }

    public void print() {
        for (Customer value : customer) {
            System.out.println(value);
        }
    }

    public void sortByName() {
        Arrays.sort(customer, 0, sizeCustomer(), new Customer.ByNameComparator());
    }

    public void printIfCardIn(String a, String b) {
        for (int i = 0; i < customer.length; i++) {
            if (customer[i] != null && customer[i].getNumberCreditCard().compareTo(a) >= 0 &&
                    customer[i].getNumberCreditCard().compareTo(b) <= 0) {
                System.out.println(customer[i]);
            }
        }
    }
}