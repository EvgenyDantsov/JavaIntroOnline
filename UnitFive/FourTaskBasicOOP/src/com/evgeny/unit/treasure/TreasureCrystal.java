package com.evgeny.unit.treasure;

import com.evgeny.unit.dragon.CaveDragon;

import java.io.Serializable;

public class TreasureCrystal implements Treasure, Serializable {
    static final long serialVersionUID = -7588980448999010399L;
    private CaveDragon.TreasureType treasureType;
    private int idTreasure;
    private String name;
    private double cost;

    public TreasureCrystal(int idTreasure, CaveDragon.TreasureType treasureType, String name, int cost) {
        this.idTreasure = idTreasure;
        this.treasureType = treasureType;
        this.name = name;
        this.cost = cost * 3;
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
        return idTreasure + ". TreasureCrystal [" +
                "Type = " + treasureType +
                ", name = " + name +
                ", cost = " + cost + "]";
    }
}