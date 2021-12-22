package com.evgeny.unit;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Tour implements Serializable {
    public enum TypeTour {BeachTour, ExcursionTour, Cruises, TherapeuticTour, ShopTour}

    public enum TypeTransport {Plane, Bus, Train, Ship}

    public enum TypeMeal {AllInclusive, BreakfastLunchDinner, LunchDinner, BreakfastDinner, Breakfast, WithoutMeal}

    public enum Country {Egypt, Turkey, Ukraine, UAE, Russia}

    private int idTour, amountNight, countStarsHotel;
    private TypeTour typeTour;
    private TypeTransport typeTransport;
    private TypeMeal typeMeal;
    private Country country;
    private double costVoucher;
    private String nameHotel;

    public Tour() {
    }

    public Tour(int idTour, Country country, String nameHotel, TypeTour typeTour, int amountNight,
                TypeTransport typeTransport, int countStarsHotel, TypeMeal typeMeal, double costVoucher) {
        this.idTour = idTour;
        this.country = country;
        this.nameHotel = nameHotel;
        this.typeTour = typeTour;
        this.amountNight = amountNight;
        this.typeTransport = typeTransport;
        this.countStarsHotel = countStarsHotel;
        this.typeMeal = typeMeal;
        this.costVoucher = costVoucher;
    }

    public void print() {
        int number = 1;
        TypeMeal[] name = TypeMeal.values();
        for (TypeMeal tm : name) {
            System.out.println(number + ". " + tm.name());
            number++;
        }
    }

    public static Tour getTour(Scanner scanner, int idGenerator) {
        int number = 1;
        int chooseValue;
        Tour tour = new Tour(idGenerator, Country.Egypt, "", TypeTour.BeachTour,
                0, TypeTransport.Plane, 2, TypeMeal.AllInclusive, 0);
        TypeMeal[] nameMeal = TypeMeal.values();
        TypeTour[] nameTour = TypeTour.values();
        TypeTransport[] nameTransport = TypeTransport.values();
        Country[] nameCountry = Country.values();
        System.out.print("Choose a country: ");
        for (Country country : nameCountry) {
            System.out.println(number + ". " + country.name());
            number++;
        }
        chooseValue = scanner.nextInt();
        for (Country country : nameCountry) {
            if ((chooseValue - 1) == country.ordinal()) {
                tour.country = Country.valueOf(country.name());
            }
        }
        System.out.print("Enter hotel: ");
        tour.nameHotel = scanner.nextLine();
        System.out.print("Choose type of tour: ");
        for (TypeTour typeTour : nameTour) {
            System.out.println(number + ". " + typeTour.name());
            number++;
        }
        chooseValue = scanner.nextInt();
        for (TypeTour typeTour : nameTour) {
            if ((chooseValue - 1) == typeTour.ordinal()) {
                tour.typeTour = TypeTour.valueOf(typeTour.name());
            }
        }
        System.out.print("Enter amount of night: ");
        tour.amountNight = scanner.nextInt();
        System.out.print("Choose type of transport: ");
        for (TypeTransport typeTransport : nameTransport) {
            System.out.println(number + ". " + typeTransport.name());
            number++;
        }
        chooseValue = scanner.nextInt();
        for (TypeTransport typeTransport : nameTransport) {
            if ((chooseValue - 1) == typeTransport.ordinal()) {
                tour.typeTransport = TypeTransport.valueOf(typeTransport.name());
            }
        }
        System.out.print("Enter count stars a hotel 2 to 5: ");
        tour.countStarsHotel = scanner.nextInt();
        System.out.print("Choose type of meal: ");
        for (TypeMeal typeMeal : nameMeal) {
            System.out.println(number + ". " + typeMeal.name());
            number++;
        }
        chooseValue = scanner.nextInt();
        for (TypeMeal typeMeal : nameMeal) {
            if ((chooseValue - 1) == typeMeal.ordinal()) {
                tour.typeMeal = TypeMeal.valueOf(typeMeal.name());
            }
        }
        System.out.print("Enter cost voucher: ");
        tour.costVoucher = scanner.nextDouble();
        return tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return idTour == tour.idTour &&
                amountNight == tour.amountNight &&
                countStarsHotel == tour.countStarsHotel &&
                Double.compare(tour.costVoucher, costVoucher) == 0 &&
                typeTour == tour.typeTour &&
                typeTransport == tour.typeTransport &&
                typeMeal == tour.typeMeal &&
                country == tour.country;
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(idTour, amountNight, countStarsHotel,
                typeTour, typeTransport, typeMeal, country, costVoucher);
    }
}
