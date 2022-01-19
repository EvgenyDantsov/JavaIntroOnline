package com.evgeny.unit.factory;

import com.evgeny.unit.box.BoxSmall;
import com.evgeny.unit.box.Box;
import com.evgeny.unit.sweet.Cake;
import com.evgeny.unit.sweet.Candy;
import com.evgeny.unit.sweet.Chocolate;
import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;

public class SmallGiftFactory implements GUIFactoryGift {
    @Override
    public Box createBox(int countBox) {
        List<Sweet> sweetnessList = new ArrayList<>();
        sweetnessList.add(new Cake(1, countBox));
        sweetnessList.add(new Chocolate(countBox));
        sweetnessList.add(new Candy(10, countBox));
        return new BoxSmall(sweetnessList, countBox);
    }
}