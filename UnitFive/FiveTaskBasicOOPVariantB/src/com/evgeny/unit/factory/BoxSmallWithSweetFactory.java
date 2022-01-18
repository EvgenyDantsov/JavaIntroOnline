package com.evgeny.unit.factory;

import com.evgeny.unit.box.BoxSmall;
import com.evgeny.unit.box.Boxx;
import com.evgeny.unit.sweet.Cake;
import com.evgeny.unit.sweet.Candy;
import com.evgeny.unit.sweet.Chocolate;
import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;

public class BoxSmallWithSweetFactory implements GUIFactoryBoxWithSweet {

    @Override
    public Boxx createBox() {
        List<Sweet> sweetnessList = new ArrayList<>();
        sweetnessList.add(new Cake(1));
        sweetnessList.add(new Chocolate());
        sweetnessList.add(new Candy(10));
        return new BoxSmall(sweetnessList);
    }
}
