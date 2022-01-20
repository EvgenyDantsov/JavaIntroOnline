package com.evgeny.unit.flowers;

public class Lilies implements Flower {
    private final String name = "Lilies";
    private double cost = 7;
    private int count;

    public Lilies(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
    }

    public Lilies(int countBox) {
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
        return "Lilies{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", count=" + count +
                '}';
    }
}