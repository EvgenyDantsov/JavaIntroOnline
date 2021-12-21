package com.evgeny.unit;

import java.util.Objects;

public class Tour {
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

    public Tour(int idTour, Country country, TypeTour typeTour, int amountNight,
                TypeTransport typeTransport, int countStarsHotel, TypeMeal typeMeal, double costVoucher) {
        this.idTour = idTour;
        this.country = country;
        this.typeTour = typeTour;
        this.amountNight = amountNight;
        this.typeTransport = typeTransport;
        this.countStarsHotel = countStarsHotel;
        this.typeMeal = typeMeal;
        this.costVoucher = costVoucher;
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
