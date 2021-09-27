package com.evgeny.unit.linear;

import java.util.Scanner;

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
