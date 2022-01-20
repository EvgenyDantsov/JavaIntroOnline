package com.evgeny.unit.factory;

import com.evgeny.unit.box.Box;
import com.evgeny.unit.box.BoxBig;
import com.evgeny.unit.flowers.*;

import java.util.ArrayList;
import java.util.List;

public class BigFloralCompositionFactory implements GUIFactoryFloralComposition {
    @Override
    public Box createBox(int countBox) {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Rose(20, countBox));
        flowerList.add(new Peonies(15, countBox));
        flowerList.add(new Lilies(10, countBox));
        return new BoxBig(flowerList, countBox);
    }
}