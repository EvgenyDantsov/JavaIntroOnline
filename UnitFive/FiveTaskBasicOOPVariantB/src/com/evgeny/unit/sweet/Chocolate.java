package com.evgeny.unit.sweet;

public class Chocolate implements Sweet {
    private final String name = "Chocolate";
    private double cost = 1.8;
    private double weight = 0.1;
    private int count;

    public Chocolate(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
        this.weight *= countBox;

    }

    public Chocolate(int countBox) {
        this.count = countBox;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost * count;
    }

    public double getWeight() {
        return weight * count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                ", count=" + count +
                '}';
    }
}