package com.evgeny.unit;

import java.util.Scanner;

public class Engine {
    private double power;

    public Engine(double power) {
        this.power = power;
    }

    public String toString() {
        return "Мощность двигателя: " + power;
    }

    public static Engine getEngine(Scanner scanner) {
        Engine engine = new Engine(0);
        System.out.print("Введите мощность двигателя: ");
        engine.power = Double.parseDouble(scanner.next());
        return engine;
    }
}
