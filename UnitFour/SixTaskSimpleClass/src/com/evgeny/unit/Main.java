package com.evgeny.unit;

//Составьте описание класса для представления времени. Предусмотрте возможности
// установки времени и изменения его отдельных полей (час, минута, секунда)
// с проверкой допустимости вводимых значений. В случае недопустимых значений полей
// поле устанавливается в значение 0. Создать методы изменения времени на
// заданное количество часов, минут и секунд.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DataTime oneTime = new DataTime(5, 44, 3);
        DataTime twoTime = new DataTime(50, 3);
        DataTime threeTime = new DataTime();
        threeTime = DataTime.read(in);
        print(oneTime, twoTime, threeTime);
        oneTime.setHour(25);
        oneTime.setMinutes(22);
        oneTime.setSeconds(50);
        twoTime.addSeconds(50);
        threeTime.addSeconds(70);
        print(oneTime, twoTime, threeTime);
        oneTime.addMinutes(20);
        twoTime.addHours(3);
        threeTime.addHours(33);
        print(oneTime, twoTime, threeTime);
    }

    public static void print(DataTime oneTime, DataTime twoTime, DataTime threeTime) {
        oneTime.print();
        twoTime.print();
        threeTime.print();
        System.out.println("-----------------");
    }
}
