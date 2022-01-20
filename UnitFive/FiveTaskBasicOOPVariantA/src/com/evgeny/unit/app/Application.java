package com.evgeny.unit.app;

import com.evgeny.unit.box.Box;
import com.evgeny.unit.factory.GUIFactoryFloralComposition;

public class Application {
    private Box box;

    public Application(GUIFactoryFloralComposition factoryFloralComposition, int countBox) {
        box = factoryFloralComposition.createBox(countBox);
    }

    public void showInfoFloralComposition() {
        box.showInfoFloralComposition();
    }
}