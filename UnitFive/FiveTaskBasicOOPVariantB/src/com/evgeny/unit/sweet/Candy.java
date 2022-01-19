package com.evgeny.unit.sweet;

public class Candy implements Sweet {
    private final String name = "Candy";
    private double cost = 0.2;
    private double weight = 0.05;
    private int count;

    public Candy(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
        this.weight *= countBox;
    }

    public Candy(int countBox) {
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
        return "Candy{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                ", count=" + count +
                '}';
    }
}