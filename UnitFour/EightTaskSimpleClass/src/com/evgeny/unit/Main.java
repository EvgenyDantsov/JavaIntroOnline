package com.evgeny.unit;

//Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы,
// set- и get- методы и метод toString(). Создать второй класс, агрегирующий массив
// типа Customer, с подходящими конструкторами и методами. Задать критерии выбора
// данных и вывести эти данные на консоль.
//Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
//        Найти и вывести:
//        a) список покупателей в алфавитном порядке;
//        b) список покупателей, у которых номер кредитной карточки находится в заданном интервале

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Customers customers = new Customers(1);
        while (true) {
            System.out.print(
                    "Выберете пункт меню:\n" +
                            "0. Выйти\n" +
                            "1. Добавить покупателя\n" +
                            "2. Вывод покупателей в алфавитном порядке\n" +
                            "3. Вывод покупателей с номером кредитной картой в заданном интервале\n" +
                            "Введите номер пункта меню: ");
            int choice = in.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 3) {
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
            }
        }
    }
}
