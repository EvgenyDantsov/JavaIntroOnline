package com.evgeny.unit;

//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Корректно спроектируйте и реализуйте предметную область задачи.
//• Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.
//• Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
//• для проверки корректности переданных данных можно применить регулярные выражения.
//• Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
//• Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
//Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки
// (объект, представляющий собой подарок). Составляющими целого подарка являются сладости и упаковка.

import com.evgeny.unit.app.Application;
import com.evgeny.unit.factory.BigGiftFactory;
import com.evgeny.unit.factory.MiddleGiftFactory;
import com.evgeny.unit.factory.SmallGiftFactory;
import com.evgeny.unit.factory.GUIFactoryGift;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static Application configureApplication(int number, int count) {
        Application app;
        GUIFactoryGift factoryGift;
        if (number == 1) {
            factoryGift = new SmallGiftFactory();
            app = new Application(factoryGift, count);
        } else if (number == 2) {
            factoryGift = new MiddleGiftFactory();
            app = new Application(factoryGift, count);
        } else {
            factoryGift = new BigGiftFactory();
            app = new Application(factoryGift, count);
        }
        return app;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d+"); //шаблон поиска (цифровой символ, один или несколько)
        while (true) {
            System.out.print("Enter the count of smallBox: ");
            String small = in.nextLine();
            Matcher matcher = pattern.matcher(small);
            if (matcher.matches()) { //поиск совпадений во всей строки с шаблоном
                if (Integer.parseInt(small) != 0) {
                    Application appSmallGift = configureApplication(1, Integer.parseInt(small));
                    appSmallGift.showInfoGift();
                    break;
                }
                break;
            } else System.out.println("Incorrect input. Enter a number.");
        }
        while (true) {
            System.out.print("Enter the count of middleBox: ");
            String middle = in.nextLine();
            Matcher matcher = pattern.matcher(middle);
            if (matcher.matches()) { //поиск совпадений во всей строки с шаблоном
                if (Integer.parseInt(middle) != 0) {
                    Application appMiddleGift = configureApplication(2, Integer.parseInt(middle));
                    appMiddleGift.showInfoGift();
                    break;
                }
                break;
            } else System.out.println("Incorrect input. Enter a number.");
        }
        while (true) {
            System.out.print("Enter the count of bigBox: ");
            String big = in.nextLine();
            Matcher matcher = pattern.matcher(big);
            if (matcher.matches()) { //поиск совпадений во всей строки с шаблоном
                if (Integer.parseInt(big) != 0) {
                    Application appBigGift = configureApplication(3, Integer.parseInt(big));
                    appBigGift.showInfoGift();
                    break;
                }
                break;
            } else System.out.println("Incorrect input. Enter a number.");
        }
    }
}