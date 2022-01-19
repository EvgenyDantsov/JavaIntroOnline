package com.evgeny.unit.box;

import com.evgeny.unit.sweet.Sweet;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoxSmall implements Box {
    private double cost = 1;
    private int countBox = 0;
    private List<Sweet> sweetnessList = new ArrayList<>();
    private final String typeBox = "Small box";

    public BoxSmall(List<Sweet> sweetness, int countBox) {
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
        System.out.println("One gift includes:");
        for (Sweet sw : sweetnessList) {
            cost += sw.getCost();
            weight += sw.getWeight();
            System.out.println(id + ". " + sw.getName() + ": " + sw.getCount() + " piece(s)");
            id++;
        }
        System.out.println("The total weight of the " + this.countBox + " gift(s): " + weight + " kg.\n" +
                "The total cost of the " + this.countBox + " gift(s): " + cost +
                " plus the price for the " + getTypeBox() + " package: " + getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxSmall boxSmall = (BoxSmall) o;
        return Double.compare(boxSmall.cost, cost) == 0 &&
                countBox == boxSmall.countBox &&
                Objects.equals(sweetnessList, boxSmall.sweetnessList);
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(cost, countBox, sweetnessList, typeBox);
    }
}