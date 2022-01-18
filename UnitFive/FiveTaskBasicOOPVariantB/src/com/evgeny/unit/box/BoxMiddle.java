package com.evgeny.unit.box;

import com.evgeny.unit.sweet.Sweet;

import java.util.ArrayList;
import java.util.List;

public class BoxMiddle implements Boxx {
    private List<Sweet> sweetnessList = new ArrayList<>();
    private final double maxWeight = 10;
    private final double cost = 3;
    private final String typebox = "Middle box";

    public BoxMiddle(List<Sweet> sweetness) {
        sweetnessList.addAll(sweetness);
    }
@Override
    public String getTypeBox() {
        return typebox;
    }
    @Override
    public double getMaxWeight() {
        return maxWeight;
    }
@Override
    public double getCost() {
        return cost;
    }
    @Override
    public void showInfoGift(){

        double cost = 0;
        double weight = 0;
        for (Sweet sw: sweetnessList){

            cost += sw.getCost();
            weight += sw.getWeight();
        }
        System.out.println("The total weight of the gift: " + weight + "\n" +
                "The total cost of the gift: " + cost +
                " plus the price for the "+ getTypeBox() + " package: " + getCost()
        );
    }
}