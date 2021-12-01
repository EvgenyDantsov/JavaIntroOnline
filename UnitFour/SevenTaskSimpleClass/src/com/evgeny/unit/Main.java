package com.evgeny.unit;

//Описать класс, представляющий треугольник. Предусмотреть методы для создания
// объектов, вычисления площади, периметра и точки пересечения медиан.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Point a = new Point();
        Point b = new Point();
        Point c = new Point();
        System.out.println("Введите A: ");
        a.read(in);
        System.out.println("Введите B: ");
        b.read(in);
        System.out.println("Введите C: ");
        c.read(in);
        Triangle triangle = new Triangle(a, b, c);
        System.out.println("square: " + triangle.square());
        System.out.println("perimeter: " + triangle.perimeter());
        System.out.print("median_crossing: ");
        triangle.medianCrossing().print();
    }
}
