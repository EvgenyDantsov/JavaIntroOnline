package com.evgeny.unit.factory;

import com.evgeny.unit.box.BoxMiddle;
import com.evgeny.unit.box.Box;
import com.evgeny.unit.sweet.Cake;
import com.evgeny.unit.sweet.Candy;
import com.evgeny.unit.sweet.Chocolate;
import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;

public class MiddleGiftFactory implements GUIFactoryGift {
    @Override
    public Box createBox(int countBox) {
        List<Sweet> sweetnessList = new ArrayList<>();
        sweetnessList.add(new Cake(2, countBox));
        sweetnessList.add(new Chocolate(2, countBox));
        sweetnessList.add(new Candy(20, countBox));
        return new BoxMiddle(sweetnessList, countBox);
    }
}