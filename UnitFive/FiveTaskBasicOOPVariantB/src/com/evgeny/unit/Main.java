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

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Box box;
    private static List<Sweetness> sweetnessList = new ArrayList<>();

    public static void main(String[] args) {
        //имитация/заглушка меню
        choosingGifts("Cake, cake or chocolate and candy");
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
    private static Box choosingBox(List<Sweetness>  swt) {
        double weight = 0;
        for (Sweetness sw : swt) {
            weight += sw.getWeight();
        }
        if (weight <= 3) {
            return new BoxSmall(swt);
        } else if (weight <= 10) {
            return new BoxMiddle(swt);
        } else {
            return new BoxBig(swt);
        }
    }
}
