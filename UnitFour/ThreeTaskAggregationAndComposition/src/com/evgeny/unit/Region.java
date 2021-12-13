package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;

public class Region {
    private String nameRegion;
    private double square;
    private List<District> districtsList = new ArrayList<>();

    public Region(String nameRegion, double square, List districtsList){
        this.nameRegion = nameRegion;
        this.square = square;
        this.districtsList = districtsList;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public double getSquare() {
        return square;
    }
    public static Region addRegion(){
        Region region = new Region("", 0 , null);
        System.out.print("Введите область: ");
        return null;
    }
}
