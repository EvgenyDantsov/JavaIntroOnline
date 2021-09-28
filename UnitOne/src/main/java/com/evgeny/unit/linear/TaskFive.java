package com.evgeny.unit.linear;

import java.util.Scanner;

//Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
// Вывести данное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc.

public class TaskFive {
    public static void main(String[] args) {
        int Т;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите Т: ");
        Т = in.nextInt();
        System.out.println(Т/3600+"ч "+(Т/60)%60+"мин "+Т%60+"с");
    }
}

