package com.evgeny.unit;

import java.util.Comparator;

public class Train {
    private String destination;
    private int numberTrain;
    private String departureTime;

    public int getNumberTrain() {
        return numberTrain;
    }

    public Train(String destination, int numberTrain, String departureTime) {
        this.destination = destination;
        this.numberTrain = numberTrain;
        this.departureTime = departureTime;
    }

    public static class ByNumberComparator implements Comparator<Train> {
        @Override
        public int compare(Train left, Train right) {
            return left.numberTrain - right.numberTrain;
        }
    }

    public static class ByDestinationAndTimeComparator implements Comparator<Train> {
        @Override
        public int compare(Train left, Train right) {
            if (left.destination == right.destination)
                return left.departureTime.compareTo(right.departureTime);
            return left.destination.compareTo(right.destination);
        }
    }

    public void print() {
        System.out.println(numberTrain + " -> " + destination + " : " + departureTime);
    }
}
