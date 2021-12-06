package com.evgeny.unit;

//Создать класс Book, спецификация которого приведена ниже. Определить конструкторы,
// set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив
// типа Book, с подходящими конструкторами и методами. Задать критерии выбора
// данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//        Найти и вывести:
//        a) список книг заданного автора;
//        b) список книг, выпущенных заданным издательством;
//        c) список книг, выпущенных после заданного года.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Books customers = new Books(1);
        while (true) {
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Выйти\n" +
                            "1. Добавить книгу\n" +
                            "2. Вывод списка книг заданного автора\n" +
                            "3. Вывод списка книг, выпущенных заданным издательством\n" +
                            "4. Вывод списка книг, выпущенных после заданного года\n" +
                            "Введите номер пункта меню: ");
            int choice = in.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 4) {
                System.out.println("выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    customers.pushBack(Customer.getCustomer(in));
                    break;
                case 2:
                    customers.sortByName();
                    customers.print();
                    break;
                case 3:
                    System.out.println("Введи диапазон кредитных карт\n");
                    System.out.print("От: ");
                    String from = in.next();
                    System.out.print("До: ");
                    String to = in.next();
                    customers.printIfCardIn(from, to);
                    break;
                case 4:break;
            }
        }
    }
    }
}
