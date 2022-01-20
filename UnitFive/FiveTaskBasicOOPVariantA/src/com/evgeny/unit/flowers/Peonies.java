package com.evgeny.unit.flowers;

public class Peonies implements Flower {
    private final String name = "Peonies";
    private double cost = 12;
    private int count;

    public Peonies(int count, int countBox) {
        this.count = count;
        this.cost *= countBox;
    }

    public Peonies(int countBox) {
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
        return "Peonies{" +
                "name='" + name + '\'' +
                ", cost=" + getCost() +
                ", count=" + count +
                '}';
    }
}