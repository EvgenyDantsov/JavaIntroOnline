package com.evgeny.unit.decompositionMethods;

//Вычислить площадь правильного шестиугольника со стороной а,
// используя метод вычисления площади треугольника.

import java.util.Scanner;

public class TaskThreeDecomposition {
    public static void main(String[] args) {
        int a;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите a: ");
        a = in.nextInt();
        System.out.print("Площадь правильного шестиугольник со стороной " + a + ": ");
        System.out.format("%.2f", areaHexagon(a));
    }

    public static double areaHexagon(int a) {
        return (3 * a * a * Math.sqrt(3)) / 2;
    }
}