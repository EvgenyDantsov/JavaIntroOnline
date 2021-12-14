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

    public State() {
    }

    String getCountry() {
        return country;
    }

    String getCapital() {
        return capital;
    }

    public List<Region> getRegionList() {
        return regionsList;
    }

    public List<District> getDistrictsList() {
        return districtsList;
    }

    public List<City> getCitiesList() {
        return citiesList;
    }

    public void menu() {
        State state = new State(State.stringInput("Введите название страны: "),
                State.stringInput("Введите название столицы: "));
        while (true) {
            System.out.println("Выберите команду:\n" +
                    "0 - выход\n" +
                    "1 - добавить область, район, город\n" +
                    "2 - вывести на консоль столицу\n" +
                    "3 - количество областей\n" +
                    "4 - площадь\n" +
                    "5 - областные центры");
            int choice = valueInput("Введите значение: ");
            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > 5) {
                System.out.println("Повторите ввод");
                continue;
            }
            switch (choice) {
                case 1:
                    addState(state);
                    break;
                case 2:
                    System.out.println("Страна: " + state.getCountry());
                    System.out.println("Столица: " + state.getCapital());
                    break;
                case 3:
                    System.out.println("Кол-во областей: " + state.getRegionList().size());
                    break;
                case 4:
                    System.out.println("Площадь всех областей: " + state.squareRegions());
                    break;
                case 5:
                    System.out.println("Областные центры:");
                    state.getRegionList()
                            .stream()
                            .map(Region::getNameRegion)
                            .forEach(System.out::println);
            }
        }
    }

    static String stringInput(String string) {
        System.out.print(string);
        if (sc.hasNextLine()) {
            stringInput = sc.nextLine();
        } else {
            System.out.println("Недопустимый ввод");
            stringInput(string);
        }
        return stringInput;
    }

    static int valueInput(String string) {
        System.out.print(string);
        if (sc.hasNextInt()) {
            valueInput = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Недопустимый ввод");
            valueInput(string);
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

    public double squareRegions() {
        double square = 0;
        for (Region r : regionsList) {
            square += r.getSquare();
        }
        return square;
    }

    public static State addState(State state) {
        state.regionsList.add(Region.addRegion());
        state.districtsList.add(District.addDistrict());
        state.citiesList.add(City.addCity());
        return state;
    }
}
