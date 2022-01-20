package com.evgeny.unit.factory;

import com.evgeny.unit.box.Box;
import com.evgeny.unit.box.BoxMiddle;
import com.evgeny.unit.flowers.*;

import java.util.ArrayList;
import java.util.List;

public class MiddleFloralCompositionFactory implements GUIFactoryFloralComposition {
    @Override
    public Box createBox(int countBox) {
        List<Flower> flowerList = new ArrayList<>();
        flowerList.add(new Rose(20, countBox));
        flowerList.add(new Tulip(20, countBox));
        flowerList.add(new Lilies(6, countBox));
        return new BoxMiddle(flowerList, countBox);
    }
}