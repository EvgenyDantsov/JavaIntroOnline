package com.evgeny.unit;

public class District {
    private String nameDistrict;

    public District(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    String getDistrict() {
        return nameDistrict;
    }

    static District addDistrict() {
        District district = new District("");
        System.out.print("Введите район: ");
        district.nameDistrict = State.stringInput("");
        State.sc.nextLine();
        return district;
    }
}
