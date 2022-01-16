package com.evgeny.unit.treasure;

import com.evgeny.unit.dragon.CaveDragon;

public interface Treasure {
    CaveDragon.TreasureType getTreasureType();
    String getName();
    double getCost();
}