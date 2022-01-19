package com.evgeny.unit.app;

import com.evgeny.unit.box.Box;
import com.evgeny.unit.factory.GUIFactoryGift;

public class Application {
    private Box box;

    public Application(GUIFactoryGift factoryGift, int countBox) {
        box = factoryGift.createBox(countBox);
    }

    public void showInfoGift() {
        box.showInfoGift();
    }
}