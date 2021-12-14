package com.evgeny.unit.decompositionMethods;

//Даны числа X, Y, Z, Т — длины сторон четырехугольника.
// Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y — прямой.

import java.util.Scanner;

public class TaskNineDecomposition {
    public static void main(String[] args) {
        int X, Y, Z, T;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите длину стороны X: ");
        X = in.nextInt();
        System.out.print("Введите длину стороны Y: ");
        Y = in.nextInt();
        System.out.print("Введите длину стороны Z: ");
        Z = in.nextInt();
        System.out.print("Введите длину стороны T: ");
        T = in.nextInt();
        squareQuadrangle(X, Y, Z, T);
    }

    public static double squareRectangularTriangle(int X, int Y) {
        return 0.5 * X * Y;
    }

    public static double hypotenuseRectangularTriangle(int X, int Y) {
        return Math.sqrt(X * X + Y * Y);
    }

    public static void squareQuadrangle(int X, int Y, int Z, int T) {
        double p, squareTwoTriangle, a;
        a = hypotenuseRectangularTriangle(X, Y);
        p = (a + Z + T) / 2;
        if (p > a && p > Z && p > T) {
            squareTwoTriangle = Math.sqrt(p * (p - hypotenuseRectangularTriangle(X, Y)) * (p - Z) * (p - T));
            System.out.print("Площадь четырехугольника: " + (squareRectangularTriangle(X, Y) + squareTwoTriangle));
        } else System.out.println("Четырехугольника с такими сторонами не существует.");

    }
}