package com.evgeny.unit;

import java.util.LinkedList;

public class Airlines {
    private LinkedList<Airline> listAirline;

    public Airlines(LinkedList<Airline> listAirline) {
        this.listAirline = listAirline;
    }

    public void printFlightDestination(final String destination) {
        listAirline.stream()
                .filter(airline -> airline.getDestination().compareTo(destination) == 0)
                .forEach(System.out::println);
    }

    public void printFlightDaysOfTheWeek(String daysOfTheWeek) {
        listAirline.stream()
                .filter(airline -> airline.getDaysOfTheWeek().compareTo(daysOfTheWeek) == 0)
                .forEach(System.out::println);
    }

    public void printFlightDaysOfTheWeekAndTimeDepartureMore(String daysOfTheWeek, String timeDeparture) {
        listAirline.stream()
                .filter(airline -> airline.getDaysOfTheWeek().compareTo(daysOfTheWeek) == 0 &&
                        airline.getTimeDeparture().compareTo(timeDeparture) > 0)
                .forEach(System.out::println);
    }
}