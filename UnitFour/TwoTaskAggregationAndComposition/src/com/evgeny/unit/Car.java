package com.evgeny.unit;

import java.util.Scanner;

public class Car {
    private Wheel wheels[];
    private Engine engine;
    private String brand;
    private double consumptionFuel;
    private double fuelLevel;

    public Car(String brand, double consumptionFuel,
               Engine engine, Wheel wheels[], double fuelLevel) {
        this.brand = brand;
        this.consumptionFuel = consumptionFuel;
        this.engine = engine;
        this.wheels = wheels;
        this.fuelLevel = fuelLevel;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(
                    "Выберите пункт меню:\n" +
                            "0. Выход\n" +
                            "1. Ехать\n" +
                            "2. Заправиться\n" +
                            "3. Поменять колесо\n" +
                            "4. Вывести информацию об автомобиле\n" +
                            "Выберите пунк меню: "
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;
            if (choice < 1 || choice > 4) {
                System.out.println("Выбран неправильный пункт меню, повторите ввод.");
                continue;
            }
            switch (choice) {
                case 1:
                    moveCar();
                    break;
                case 2:
                    System.out.print("Введите количество топлива: ");
                    double fuel = scanner.nextDouble();
                    addFuel(fuel);
                    break;
                case 3:
                    changeWheel(scanner);
                    break;
                case 4:
                    System.out.println(toString());
                    break;
            }
        }
    }

    public String toString() {
        String string = "";
        string += "Марка автомобиля: " + brand + ". " + engine.toString() + "; " + consumptionFuel + "L/100 км." +
                " Количество топлива в баке: {" + fuelLevel + "}.\n";
        for (int i = 0; i < 4; ++i) {
            string += wheels[i].toString() + "\n";
        }
        return string;
    }

    public static Car getCar(Scanner scanner) {
        Car car = new Car("", 0, new Engine(0), new Wheel[4], 0);
        System.out.print("Введите марку автомобиля: ");
        car.brand = scanner.next();
        System.out.print("Введите расход топлива на 100км: ");
        car.consumptionFuel = Double.parseDouble(scanner.next());
        System.out.print("Введите текущий уровень топлива: ");
        car.fuelLevel = Double.parseDouble(scanner.next());
        for (int i = 0; i < 4; ++i) {
            System.out.println("Колесо №" + (i + 1));
            car.wheels[i] = Wheel.getWheel(scanner);
        }
        car.engine = Engine.getEngine(scanner);
        return car;
    }

    public void moveCar() {
        if (fuelLevel <= 0) {
            System.out.println("Нет бензина, машина не может ехать.");
            return;
        }
        for (int i = 1; i < 4; ++i) {
            if (wheels[i].getDiameter() != wheels[i - 1].getDiameter()) {
                System.out.println("Колеса разных диаметров, машина не может ехать, замените колеса.");
                return;
            }
        }
        double distance = fuelLevel / consumptionFuel;
        System.out.println("Машина проехала: " + distance * 100 + " км.");
        fuelLevel = 0;
    }

    public void addFuel(double value) {
        fuelLevel += value;
    }

    public void changeWheel(Scanner scanner) {
        System.out.print("Введите номер колеса [1-4]: ");
        int number;
        while (true) {
            number = scanner.nextInt();
            if (number >= 1 && number <= 4)
                break;
            System.out.println("Неправильный номер, повтори ввод");
        }
        wheels[number - 1] = Wheel.getWheel(scanner);
    }
}
