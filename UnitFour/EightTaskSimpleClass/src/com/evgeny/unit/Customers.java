package com.evgeny.unit;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Customers {
    private Customer[] customer;
    private LinkedList<Customer> listCustomer=new LinkedList<Customer>();//new
    private int capacity;
    private int size;
public Customers(LinkedList<Customer> listCustomer){
    this.listCustomer = listCustomer;
}
   // public Customers(int capacity) {
       // size = 0;
       // this.capacity = capacity;
      //  this.customer = new Customer[capacity];
   // }

//    public void pushBack(Customer customer) {
//        if (size < capacity) {
//            this.customer[size] = customer;
//            size++;
//        } else {
//            Customer[] buffer = new Customer[capacity * 2];
//            for (int i = 0; i < size; ++i) {
//                buffer[i] = this.customer[i];
//            }
//            this.customer = buffer;
//            capacity = capacity * 2;
//            this.customer[size] = customer;
//            size++;
//        }
//    }

    public void print() {
//        for (int i = 0; i < size; ++i) {
//            this.customer[i].print();
//        }
        for(Customer customer: listCustomer){
            System.out.println(customer);
        }
    }

    public void sortByName() {
        listCustomer.sort(new Customer.ByNameComparator());
    }

    public void printIfCardIn(String a, String b) {
        for (int i = 0; i < size; ++i) {
            if (this.customer[i].getNumberCreditCard().compareTo(a) >= 0 &&
                    this.customer[i].getNumberCreditCard().compareTo(b) <= 0)
                this.customer[i].print();
        }
    }
}
