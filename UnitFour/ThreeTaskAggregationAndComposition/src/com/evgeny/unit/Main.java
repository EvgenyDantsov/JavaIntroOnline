package com.evgeny.unit;

//Создать объект класса Государство, используя классы Область, Район, Город.
// Методы: вывести на консоль столицу, количество областей, площадь, областные центры.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
        State state = new State(State.stringInput(), State.stringInput());
        while (true) {
            System.out.println("Выберите команду:\n" +
                    "0 - выход\n" +
                    "1 - добавить область\n" +
                    "2 - вывести на консоль столицу\n" +
                    "3 - количество областей\n" +
                    "4 - площадь\n" +
                    "5 - областные центры");
            int choice = State.valueInput();
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Повторите ввод");
                continue;
            }
            switch (choice) {
                case 1:
                    state.addState();
                    break;
                case 2:
                    System.out.println("Страна: " + state.getCountry());
                    System.out.println("Столица: " + state.getCapital());
                    break;
                case 3:
                    System.out.println("Кол - во областей: " + state.getRegionList().size());
                    break;
                case 4:
                    //System.out.println("Площадь всех областей: " + country.squareRegions());
            }
        }
    }
}
