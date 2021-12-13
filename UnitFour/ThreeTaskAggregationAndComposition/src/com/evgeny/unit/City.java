package com.evgeny.unit;

public class City {
    private String nameCity;

    public City(String nameCity) {
        this.nameCity = nameCity;
    }

    String getNameCity() {
        return nameCity;
    }

    public static City addCity() {
        City city = new City("");
        System.out.print("Введите город: ");
        city.nameCity = State.stringInput();
        return city;
    }
}
