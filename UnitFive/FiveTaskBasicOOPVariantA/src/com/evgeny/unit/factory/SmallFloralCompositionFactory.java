package com.evgeny.unit.factory;

import com.evgeny.unit.box.Box;
import com.evgeny.unit.box.BoxSmall;
import com.evgeny.unit.flowers.*;

import java.util.ArrayList;
import java.util.List;

public class SmallFloralCompositionFactory implements GUIFactoryFloralComposition{
    @Override
    public Box createBox(int countBox) {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Orchid(5, countBox));
        flowerList.add(new Peonies(3, countBox));
        flowerList.add(new Lilies(5, countBox));
        return new BoxSmall(flowerList, countBox);
    }
}