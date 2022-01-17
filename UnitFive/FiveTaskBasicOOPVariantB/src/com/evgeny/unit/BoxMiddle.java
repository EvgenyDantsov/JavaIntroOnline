package com.evgeny.unit;

import java.util.List;

public class BoxMiddle extends Box {
    private final double maxWeight = 10;
    private final double cost = 3;
    private final String typebox = "Middle box";

    public BoxMiddle(List<Sweetness> swt) {
        super(swt);
    }

    public String getTypeBox() {
        return typebox;
    }
    public double getMaxWeight() {
        return maxWeight;
    }

    public double getCost() {
        return cost;
    }
}