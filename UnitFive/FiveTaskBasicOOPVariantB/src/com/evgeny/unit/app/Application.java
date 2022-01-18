package com.evgeny.unit.app;

import com.evgeny.unit.box.Boxx;
import com.evgeny.unit.factory.GUIFactoryBoxWithSweet;

public class Application {
    private Boxx boxx;

    public Application(GUIFactoryBoxWithSweet factoryBoxWithSweet){
        boxx = factoryBoxWithSweet.createBox();
    }
    public void showInfoGift(){
        boxx.showInfoGift();
    }
}
