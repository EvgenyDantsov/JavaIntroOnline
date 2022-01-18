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
import com.evgeny.unit.box.*;
import com.evgeny.unit.factory.BoxBigWithSweetFactory;
import com.evgeny.unit.factory.BoxMiddleWithSweetFactory;
import com.evgeny.unit.factory.BoxSmallWithSweetFactory;
import com.evgeny.unit.factory.GUIFactoryBoxWithSweet;
import com.evgeny.unit.sweet.Cake;
import com.evgeny.unit.sweet.Chocolate;
import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Box box;
    private static List<Sweet> sweetnessList = new ArrayList<>();
    private static Application configureApplication(int number, int count){
        Application app;
        GUIFactoryBoxWithSweet factoryBoxWithSweet;
        if(number == 1){
            factoryBoxWithSweet = new BoxSmallWithSweetFactory();
            app = new Application(factoryBoxWithSweet);
        }else  if(number == 2){
            factoryBoxWithSweet = new BoxMiddleWithSweetFactory();
            app = new Application(factoryBoxWithSweet);
        }else {
            factoryBoxWithSweet = new BoxBigWithSweetFactory();
            app = new Application(factoryBoxWithSweet);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //имитация/заглушка меню
            System.out.print("Enter the count of smallBox: ");
            int small = in.nextInt();
            System.out.print("Enter the count of middleBox: ");
            int middle = in.nextInt();
            System.out.print("Enter the count of bigBox: ");
            Application app = configureApplication(1,small);
            app.showInfoGift();
        box = choosingBox(sweetnessList);

        box.showInfoGift();

    }

    //указываем слодости и имтируем создание большого колличества объектов
    private static void choosingGifts(String str) {
        if (str.toLowerCase().contains("cake")) {
            sweetnessList.add(new Cake(1));
        }
        if (str.toLowerCase().contains("chocolate")) {
            sweetnessList.add(new Chocolate());
        }
        if (str.toLowerCase().contains("candy")) {
            sweetnessList.add(new Cake(10));
        }
    }

    //распределяем сладости по коробкам, в зависимости от их веса
    private static Boxx choosingBox(List<Sweet>  sweetness) {
        double weight = 0;
        for (Sweet sw : sweetness) {
            weight += sw.getWeight();
        }
        if (weight <= 3) {
            return new BoxSmall(sweetness);
        } else if (weight <= 10) {
            return new BoxMiddle(sweetness);
        } else {
            return new BoxBig(sweetness);
        }
    }
}
