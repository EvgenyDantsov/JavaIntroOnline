package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;

public class District {
    private String nameDistrict;
    private List<City> citiesList = new ArrayList<>();

   public District(String nameDistrict, List citiesList) {
        this.nameDistrict = nameDistrict;
        this.citiesList = citiesList;
    }

    String getDistrict() {
        return nameDistrict;
    }
    static District addDistrict() {
        District district = new District("", null);
        System.out.print("Введите райной: ");
        district.nameDistrict = State.stringInput();
        district.citiesList.add(City.addCity());
        return district;
    }
}
