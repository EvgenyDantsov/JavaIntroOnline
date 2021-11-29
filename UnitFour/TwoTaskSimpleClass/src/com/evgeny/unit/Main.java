package com.evgeny.unit;

//Создйте класс Test2 c двумя переменными. Добавьте конструктор с входными параметрами.
// Добавьте конструктор, инициализирующий члены класса по умолчанию.
// Добавьте set- и get- методы для полей экземпляра класса.

public class Main {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println("Конструктор по умолчанию:");
        System.out.println("one: " + test2.getOne());
        System.out.println("two: " + test2.getTwo());
        System.out.println("Изменения полей экземпляра класса:");
        test2.setOne(5);
        test2.setTwo(10);
        System.out.println("one: " + test2.getOne());
        System.out.println("two: " + test2.getTwo());
        System.out.println("Конструктор с входными параметрами:");
        test2 = new Test2(10, 20);
        System.out.println("one: " + test2.getOne());
        System.out.println("two: " + test2.getTwo());
    }
}
