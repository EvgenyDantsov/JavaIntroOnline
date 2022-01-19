package com.evgeny.unit.sweet;

public class Cake implements Sweet {
    private final String name = "Cake";
    private double cost = 7;
    private double weight = 0.9;
    private int count;

    public Cake(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
        this.weight *= countBox;
    }

    public Cake(int countBox) {
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
        return "Cake{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", weight=" + getWeight() +
                ", count=" + count +
                '}';
    }
}