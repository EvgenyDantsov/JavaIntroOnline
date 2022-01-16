package com.evgeny.unit.treasure;

import com.evgeny.unit.dragon.CaveDragon;

public class TreasureIron implements Treasure {
    private CaveDragon.TreasureType treasureType;
    private String name;
    private double cost;

    public TreasureIron(CaveDragon.TreasureType treasureType, String name, int cost) {
        this.treasureType = treasureType;
        this.name = name;
        this.cost = cost;
    }


    @Override
    public CaveDragon.TreasureType getTreasureType() {
        return treasureType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "TreasureCopper{" +
                "treasureType=" + treasureType +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}