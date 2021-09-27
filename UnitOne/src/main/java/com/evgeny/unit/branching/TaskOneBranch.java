package com.evgeny.unit.branching;

import java.util.Scanner;

public class TaskOneBranch {
    public static void main(String[] args) {
        double cornerOne, cornerTwo;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите cornerOne: ");
        cornerOne = in.nextInt();
        System.out.print("Введите cornerTwo: ");
        cornerTwo = in.nextInt();
        if (cornerOne + cornerTwo < 180) {
            System.out.println("Треугольник существует.");
            if (180 - (cornerOne + cornerTwo) == 90 || cornerOne == 90 || cornerTwo == 90) {
                System.out.println("Треугольник прямоугольный.");
            }
        } else System.out.println("Треугольник с такими углами не существует!");
    }
}
