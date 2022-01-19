package com.evgeny.unit.box;

import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoxBig implements Box {
    private List<Sweet> sweetnessList = new ArrayList<>();
    private double cost = 5;
    private int countBox = 0;
    private final String typeBox = "Big box";

    public BoxBig(List<Sweet> sweetness, int countBox) {
        this.countBox = countBox;
        this.cost *= countBox;
        sweetnessList.addAll(sweetness);
    }

    @Override
    public String getTypeBox() {
        return typeBox;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public void showInfoGift() {
        double cost = 0;
        double weight = 0;
        for (Sweet sw : sweetnessList) {
            cost += sw.getCost();
            weight += sw.getWeight();
        }
        System.out.println("The total weight of the " + this.countBox + " gift(s): " + weight + " kg.\n" +
                "The total cost of the " + this.countBox + " gift(s): " + cost +
                " plus the price for the " + getTypeBox() + " package: " + getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxBig boxBig = (BoxBig) o;
        return Double.compare(boxBig.cost, cost) == 0 &&
                countBox == boxBig.countBox &&
                Objects.equals(sweetnessList, boxBig.sweetnessList);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(sweetnessList, cost, countBox);
    }
}