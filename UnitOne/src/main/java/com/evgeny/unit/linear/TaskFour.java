package com.evgeny.unit.linear;

//Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
// Поменять местами дробную и целую части числа и вывести полученное значение числа.

public class TaskFour {
    public static void main(String[] args) {
        double R = 321.123;
        System.out.println(R);
        System.out.println((R * 1000) % 1000 + (int) R / 1000.0);
    }
}
