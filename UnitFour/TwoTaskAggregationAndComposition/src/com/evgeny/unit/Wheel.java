package com.evgeny.unit;

import java.util.Scanner;

public class Wheel {
    public enum Type {Winter, Summer}

    private double diameter;
    private String brand;
    private Type typeWheel;

    public Wheel(String brand, double diameter, Type typeWheel) {
        this.brand = brand;
        this.diameter = diameter;
        this.typeWheel = typeWheel;
    }

    public String toString() {
        String string = "";
        string += "Марка шины: " + brand + ", диаметр колеса: (" + diameter + "): ";
        if (typeWheel == Type.Winter)
            string += "зимние.";
        else
            string += "летние.";
        return string;
    }

    public static Wheel getWheel(Scanner scanner) {
        Wheel wheel = new Wheel("", 0, Type.Winter);
        System.out.print("Введите бренд колеса: ");
        wheel.brand = scanner.next();
        System.out.print("Введите диаметр колеса: ");
        wheel.diameter = scanner.nextDouble();
        System.out.print("Выберите тип: (1) - зимние, (2) - летние: ");
        while (true) {
            int value = scanner.nextInt();
            if (value == 1) {
                wheel.typeWheel = Type.Winter;
                break;
            }
            if (value == 2) {
                wheel.typeWheel = Type.Summer;
                break;
            }
            System.out.print("Введено неправильное значение, повтори ввод.");
        }
        return wheel;
    }

    public double getDiameter() {
        return diameter;
    }
}
