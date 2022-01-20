package com.evgeny.unit.flowers;

public class Orchid implements Flower {
    private final String name = "Orchid";
    private double cost = 8;
    private int count;

    public Orchid(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
    }

    public Orchid(int countBox) {
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
        return "Orchid{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", count=" + count +
                '}';
    }
}