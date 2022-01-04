package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tours {
    private int idGeneratorTour;
    private List<Tour> tourList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public Tours(List tourList) {
        this.tourList = tourList;
    }

    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }

    public int idGeneratorTour() {
        if (getTourList().size() > 0) {
            idGeneratorTour = getTourList().size() + 1;
        } else idGeneratorTour = 1;
        return idGeneratorTour;
    }

    public int getIdGeneratorTour() {
        return idGeneratorTour;
    }

    public void setIdGeneratorTour(int idGeneratorTour) {
        this.idGeneratorTour = idGeneratorTour;
    }

    public void menu() {
       CreateFile cf = new CreateFile();
        while (true) {
            System.out.print(
                    "Select the menu item:\n" +
                            "0. Exit\n" +
                            "1. Show tours that meet user criteria\n" +
                            "Enter the menu item number: ");
            int choice = in.nextInt();
            if (choice == 0) {
                cf.serializationFile(tourList);
                break;
            }
            if (choice < 1 || choice > 2) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    Tour.searchTour(in, tourList);
                    break;
                case 2:
                    tourList.add( Tour.getTour(in, idGeneratorTour()));
                    break;
            }
        }
    }
}
