package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class State {
    static int valueInput;
    static double doubleInput;
    static String stringInput;
    String country, capital;
    static Scanner sc = new Scanner(System.in);
    private List<Region> regionsList = new ArrayList<>();
    private List<District> districtsList = new ArrayList<>();
    private List<City> citiesList = new ArrayList<>();

    public State(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }

    public State(List regionsList, List districtsList, List citiesList) {
        this.regionsList = regionsList;
        this.districtsList = districtsList;
        this.citiesList = citiesList;
    }

    String getCountry() {
        return country;
    }

    String getCapital() {
        return capital;
    }

    public List getRegionList() {
        return regionsList;
    }

    static String stringInput() {
        if (sc.hasNextLine()) {
            stringInput = sc.nextLine();
        } else {
            System.out.println("Недопустимый ввод");
            stringInput();
        }
        return stringInput;
    }

    static int valueInput() {
        if (sc.hasNextInt()) {
            valueInput = sc.nextInt();
        } else {
            System.out.println("Недопустимый ввод");
            valueInput();
        }
        return valueInput;
    }

    static double doubleInput() {
        if (sc.hasNextDouble()) {
            doubleInput = sc.nextDouble();
        } else {
            System.out.println("Недопустимый ввод");
            doubleInput();
        }
        return doubleInput;
    }

    static State addState() {
        State state = new State(null,null,null);
        state.regionsList.add(Region.addRegion());
        return state;
    }
}
