package com.evgeny.unit.box;

import com.evgeny.unit.flowers.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoxMiddle implements Box {
    private List<Flower> flowerList = new ArrayList<>();
    private double cost = 8;
    private int countBox = 0;
    private final String typeBox = "Middle box";

    public BoxMiddle(List<Flower> flowers, int countBox) {
        this.countBox = countBox;
        this.cost *= countBox;
        flowerList.addAll(flowers);
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
    public void showInfoFloralComposition() {
        double cost = 0;
        double weight = 0;
        int id = 1;
        System.out.println("One floral composition middle size includes:");
        for (Flower sw : flowerList) {
            cost += sw.getCost();
            System.out.println(id + ". " + sw.getName() + ": " + sw.getCount() + " piece(s)");
            id++;
        }
        System.out.println("The total cost of the " + this.countBox + " floral composition: " + (cost + getCost()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxMiddle boxMiddle = (BoxMiddle) o;
        return Double.compare(boxMiddle.cost, cost) == 0 &&
                countBox == boxMiddle.countBox &&
                Objects.equals(flowerList, boxMiddle.flowerList);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(flowerList, cost, countBox);
    }
}