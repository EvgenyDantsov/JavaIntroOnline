package com.evgeny.unit.menu;

import com.evgeny.unit.app.Application;
import com.evgeny.unit.factory.BigFloralCompositionFactory;
import com.evgeny.unit.factory.GUIFactoryFloralComposition;
import com.evgeny.unit.factory.MiddleFloralCompositionFactory;
import com.evgeny.unit.factory.SmallFloralCompositionFactory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private static Application configureApplication(int number, int count) {
        Application app;
        GUIFactoryFloralComposition factoryFloralComposition;
        if (number == 1) {
            factoryFloralComposition = new SmallFloralCompositionFactory();
            app = new Application(factoryFloralComposition, count);
        } else if (number == 2) {
            factoryFloralComposition = new MiddleFloralCompositionFactory();
            app = new Application(factoryFloralComposition, count);
        } else {
            factoryFloralComposition = new BigFloralCompositionFactory();
            app = new Application(factoryFloralComposition, count);
        }
        return app;
    }

    public Menu() {
        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d+"); //шаблон поиска (цифровой символ, один или несколько)
        while (true) {
            System.out.print("Enter the count of smallBox: ");
            String small = in.nextLine();
            Matcher matcher = pattern.matcher(small);
            if (matcher.matches()) { //поиск совпадений во всей строки с шаблоном
                if (Integer.parseInt(small) != 0) {
                    Application appSmallFloralComposition = configureApplication(1, Integer.parseInt(small));
                    appSmallFloralComposition.showInfoFloralComposition();
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
                    Application appMiddleFloralComposition = configureApplication(2, Integer.parseInt(middle));
                    appMiddleFloralComposition.showInfoFloralComposition();
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
                    Application appBigFloralComposition = configureApplication(3, Integer.parseInt(big));
                    appBigFloralComposition.showInfoFloralComposition();
                    break;
                }
                break;
            } else System.out.println("Incorrect input. Enter a number.");
        }
    }
}