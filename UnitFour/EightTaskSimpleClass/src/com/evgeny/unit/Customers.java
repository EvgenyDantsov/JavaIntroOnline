package com.evgeny.unit;

import java.util.LinkedList;

public class Customers {
    private LinkedList<Customer> listCustomer = new LinkedList<Customer>();

    public Customers(LinkedList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public void print() {
        listCustomer.forEach(System.out::println);
    }

    public void sortByName() {
        listCustomer.sort(new Customer.ByNameComparator());
    }

    public void printIfCardIn(String a, String b) {
        listCustomer.stream().filter(customer -> customer.getNumberCreditCard().compareTo(a) >= 0 &&
                customer.getNumberCreditCard().compareTo(b) <= 0).forEach(System.out::println);
    }
}
