package com.evgeny.unit;

//Создайте класс Test1 c двумя переменными. Добавьте метод вывода на экран
// и методы изменения этих переменных. Добавьте метод, который находит сумму значений
// этих переменных, и метод, который находит наибольшее значение из этих двух переменных.

public class Main {

    public static void main(String[] args) {
        Test1 test = new Test1();
        test.one = 10;
        test.two = 20;
        System.out.println("one: " + test.one);
        System.out.println("two: " + test.two);
        System.out.println("Наибольшее значение из двух: " + test.max());
        System.out.println("Сумма двух значений: " + test.sum());
        test.one = 15;
        System.out.println("one: " + test.one);
        System.out.println("two: " + test.two);
        System.out.println("Наибольшее значение из двух: " + test.max());
        System.out.println("Сумма двух значений: " + test.sum());
    }
}
