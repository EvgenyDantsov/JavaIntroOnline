package com.evgeny.unit;

import java.util.Comparator;
import java.util.Scanner;

public class Customer {
    private static int idGenerator;
    private int id;
    private String name, surname, patronymic, address, numberCreditCard, numberBankAccount;

    public Customer(String name, String surname, String patronymic, String address,
                    String numberCreditCard, String numberBankAccount) {
        id = idGenerator++;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.numberCreditCard = numberCreditCard;
        this.numberBankAccount = numberBankAccount;
    }

    public void print() {
        System.out.println(toString());
    }

    public String getNumberBankAccount() {
        return numberBankAccount;
    }

    public void setNumberBankAccount(String numberBankAccount) {
        this.numberBankAccount = numberBankAccount;
    }

    public String getNumberCreditCard() {
        return numberCreditCard;
    }

    public void setNumberCreditCard(String numberCreditCard) {
        this.numberCreditCard = numberCreditCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Customer getCustomer(Scanner scanner) {
        Customer customer = new Customer("", "", "", "", "", "");
        System.out.print("Фамилия: ");
        customer.surname = scanner.next();
        System.out.print("Имя: ");
        customer.name = scanner.next();
        System.out.print("Отчесто: ");
        customer.patronymic = scanner.next();
        scanner.nextLine();
        System.out.print("Адрес: ");
        customer.address = scanner.nextLine();
        System.out.print("Номер кредитной карты: ");
        customer.numberCreditCard = scanner.next();
        System.out.print("Номер банковского счета: ");
        customer.numberBankAccount = scanner.next();
        return customer;
    }

    public static class ByNameComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer left, Customer right) {
            if (left.surname != right.surname)
                return left.surname.compareTo(right.surname);
            if (left.name != right.name)
                return left.name.compareTo(right.name);
            return left.patronymic.compareTo(right.patronymic);
        }
    }

    public String toString() {
        String string = "";
        string = string + id + ". ФИО: " + name + " " + surname + " " + patronymic +
                " Address: " + address + " numberCreditCard: " + numberCreditCard + " " +
                "numberBankAccount: " + numberBankAccount;
        return string;
    }
}
