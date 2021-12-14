package com.evgeny.unit;

public class Region {
    private String nameRegion;
    private double square;

    public Region(String nameRegion, double square) {
        this.nameRegion = nameRegion;
        this.square = square;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public double getSquare() {
        return square;
    }

    public static Region addRegion() {
        Region region = new Region("", 0);
        System.out.print("Введите область: ");
        region.nameRegion = State.stringInput("");
        System.out.print("Введите площадь в км2: ");
        region.square = State.doubleInput();
        return region;
    }
}
