package com.evgeny.unit.box;

import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoxMiddle implements Box {
    private List<Sweet> sweetnessList = new ArrayList<>();
    private double cost = 3;
    private int countBox = 0;
    private final String typeBox = "Middle box";

    public BoxMiddle(List<Sweet> sweetness, int countBox) {
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
        int id = 1;
        System.out.println("One middle gift includes:");
        for (Sweet sw : sweetnessList) {
            cost += sw.getCost();
            weight += sw.getWeight();
            System.out.println(id + ". " + sw.getName() + ": " + sw.getCount() + " piece(s)");
            id++;
        }
        System.out.println("The total weight of the " + this.countBox + " gift(s): " + weight + " kg.\n" +
                "The total cost of the " + this.countBox + " gift(s): " + (cost + getCost()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxMiddle boxMiddle = (BoxMiddle) o;
        return Double.compare(boxMiddle.cost, cost) == 0 &&
                countBox == boxMiddle.countBox &&
                Objects.equals(sweetnessList, boxMiddle.sweetnessList);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(sweetnessList, cost, countBox, typeBox);
    }
}