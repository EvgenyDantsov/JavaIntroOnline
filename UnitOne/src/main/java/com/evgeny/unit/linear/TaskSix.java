package com.evgeny.unit.linear;

import java.util.Scanner;

//Для данной области составить линейную программу, которая печатает true,
// если точка с координатами (х, у) принадлежит закрашенной области, и false — в противном случае:
//область квадрата вершины: (-2;0), (-2;4), (2;4), (2;0).
//область прямоугольника вершины: (-4;0), (-4;-3), (4;0), (4;-3).

public class TaskSix {
    public static void main(String[] args) {
        int x, y;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите x: ");
        x = in.nextInt();
        System.out.print("\n" + "Введите y: ");
        y = in.nextInt();
        if ((-2 <= x && x <= 2 && 0 <= y && y <= 4) || (-4 <= x && x <= 4 && -3 <= y && y <= 0)) {
            System.out.println(true);
        } else System.out.println(false);
    }
}
