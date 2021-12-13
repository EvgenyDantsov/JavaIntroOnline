package com.evgeny.unit;

//Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
// Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = Car.getCar(scanner);
        car.menu();
    }
}
