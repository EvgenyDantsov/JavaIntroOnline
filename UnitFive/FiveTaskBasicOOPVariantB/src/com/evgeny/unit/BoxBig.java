package com.evgeny.unit;

import java.util.List;

public class BoxBig extends Box {
    private final double maxWeight = 20;
    private final double cost = 5;
    private final String typebox = "Big box";

    public BoxBig(List<Sweetness> swt) {
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
