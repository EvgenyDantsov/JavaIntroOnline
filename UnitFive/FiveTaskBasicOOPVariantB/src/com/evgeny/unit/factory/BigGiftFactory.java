package com.evgeny.unit.factory;

import com.evgeny.unit.box.BoxBig;
import com.evgeny.unit.box.Box;
import com.evgeny.unit.sweet.Cake;
import com.evgeny.unit.sweet.Candy;
import com.evgeny.unit.sweet.Chocolate;
import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;

public class BigGiftFactory implements GUIFactoryGift {
    @Override
    public Box createBox(int countBox) {
        List<Sweet> sweetnessList = new ArrayList<>();
        sweetnessList.add(new Cake(4, countBox));
        sweetnessList.add(new Chocolate(4, countBox));
        sweetnessList.add(new Candy(40, countBox));
        return new BoxBig(sweetnessList, countBox);
    }
}