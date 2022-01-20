package com.evgeny.unit.flowers;

public class Tulip implements Flower {
    private final String name = "Tulip";
    private double cost = 5;
    private int count;

    public Tulip(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
    }

    public Tulip(int countBox) {
        this.count = countBox;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost * count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Tulip{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", count=" + count +
                '}';
    }
}