package com.evgeny.unit;

//Опишите класс, реализующий десятичный счетчик, который может увеличивать
// или уменьшать свое значение на единицу в заданном диапазоне.
// Предусмотрите инициализацию счетчика значениями по умолчанию и произвольными значениями.
// Счетчик имеет методы увеличения и уменьшения состояния, и метод позволяющее получить
// его текущее состояние. Написать код, демонстрирующий все возможности класса.

public class Main {

    public static void main(String[] args) {
        DecimalCounter oneCounter = new DecimalCounter(5, 10, 6);
        DecimalCounter twoCounter = new DecimalCounter(6, 4, 7);
        DecimalCounter threeCounter = new DecimalCounter(5, 3);
        DecimalCounter fourCounter = new DecimalCounter();
        print(oneCounter, twoCounter, threeCounter, fourCounter);
        for (int i = 0; i < 2; ++i) {
            oneCounter.increase();
            twoCounter.increase();
            threeCounter.increase();
            fourCounter.increase();
        }
        print(oneCounter, twoCounter, threeCounter, fourCounter);
        for (int i = 0; i < 20; ++i) {
            oneCounter.decreasing();
            twoCounter.decreasing();
            threeCounter.decreasing();
            fourCounter.decreasing();
        }
        print(oneCounter, twoCounter, threeCounter, fourCounter);
    }

    public static void print(DecimalCounter oneCounter, DecimalCounter twoCounter,
                             DecimalCounter threeCounter, DecimalCounter fourCounter) {
        System.out.println("oneCounter: " + oneCounter.value());
        System.out.println("twoCounter: " + twoCounter.value());
        System.out.println("threeCounter: " + threeCounter.value());
        System.out.println("fourCounter: " + fourCounter.value());
        System.out.println("----------------------");
    }
}
