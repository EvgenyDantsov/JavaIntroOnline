package com.evgeny.unit;

import java.io.Serializable;
import java.util.Scanner;

public class Airline implements Serializable {
    private static int idGeneration;
    private int id;
    private String destination, numberFlight, typePlane, timeDeparture, daysOfTheWeek;

    Airline(String destination, String numberFlight,
            String typePlane, String timeDeparture, String daysOfTheWeek) {
        id = idGeneration++;
        this.destination = destination;
        this.numberFlight = numberFlight;
        this.typePlane = typePlane;
        this.timeDeparture = timeDeparture;
        this.daysOfTheWeek = daysOfTheWeek;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNumberFlight() {
        return numberFlight;
    }

    public void setNumberFlight(String numberFlight) {
        this.numberFlight = numberFlight;
    }

    public String getTypePlane() {
        return typePlane;
    }

    public void setTypePlane(String typePlane) {
        this.typePlane = typePlane;
    }

    public String getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(String timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public String getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public void setDaysOfTheWeek(String daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
    }

    public static Airline getAirline(Scanner scanner) {
        Airline airline = new Airline("", "", "",
                "", "");
        scanner.nextLine();
        System.out.print("Пункт назначения: ");
        airline.destination = scanner.nextLine();
        System.out.print("Номер рейса: ");
        airline.numberFlight = scanner.next();
        System.out.print("Тип самолета: ");
        airline.typePlane = scanner.next();
        System.out.print("Время вылета: ");
        scanner.nextLine();
        airline.timeDeparture = scanner.nextLine();
        System.out.print("Дни недели: ");
        airline.daysOfTheWeek = scanner.nextLine();
        return airline;
    }

    @Override
    public String toString() {
        return id + ". Пункт назначения: " + destination + ". Номер рейса: " + numberFlight
                + ". Тип самолета: " + typePlane + "\nВремя вылета: " + timeDeparture +
                ". Дни недели: " + daysOfTheWeek;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Airline airline = (Airline) obj;
        return destination.equals(airline.destination) &&
                numberFlight.equals(airline.numberFlight) &&
                typePlane.equals(airline.typePlane) &&
                timeDeparture.equals(airline.timeDeparture) &&
                daysOfTheWeek.equals(airline.daysOfTheWeek);
    }

    @Override
    public int hashCode() {
        return 31 * destination.hashCode() + numberFlight.hashCode() + typePlane.hashCode() +
                timeDeparture.hashCode() + daysOfTheWeek.hashCode();
    }
}
