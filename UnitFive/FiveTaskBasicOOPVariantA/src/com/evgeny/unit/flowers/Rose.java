package com.evgeny.unit.flowers;

public class Rose implements Flower {
    private final String name = "Rose";
    private double cost = 8.5;
    private int count;

    public Rose(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
    }

    public Rose(int countBox) {
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
        return "Rose{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", count=" + count +
                '}';
    }
}