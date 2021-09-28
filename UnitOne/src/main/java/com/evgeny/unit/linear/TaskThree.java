package com.evgeny.unit.linear;

import java.util.Scanner;

//Вычислить значение выражения по формуле (все переменные принимают действительные значения):
//(sinx+cosx/cosx-sinx)*tgx*y.

public class TaskThree {
    public static void main(String[] args) {
        double result, x,y;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите x: ");
        x = in.nextDouble();
        System.out.print("\n" + "Введите y: ");
        y = in.nextDouble();
        result=((Math.sin(x)+Math.cos(y))/(Math.cos(x)+Math.sin(y)))*Math.tan(x*y);
        System.out.println("\n" + "result = " + result);
    }
}
