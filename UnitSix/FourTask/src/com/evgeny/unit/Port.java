package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;

public class Port implements Runnable{
    private List<Ship> shipList;
    private static final int minShipsInPier = 0;
    private static final int maxShipsInPier = 2;
    private int countShip;

    public Port(int countsShip) {
        shipList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < countsShip - 1; i++) {
            count++;
            System.out.println("create new ship: " + count);
            shipList.add(new Ship(count));
        }
    }

    public synchronized boolean add(Ship element, int numberShip) {
        try {
            if (countShip < maxShipsInPier) {
                notifyAll();
                shipList.add(element);
                String info = String.format("%s + The ship arrived in the port: %s Ship %s", shipList.size(), element.getSize(), numberShip);
                System.out.println(info);
                countShip++;

            } else {
                System.out.println(shipList.size() + "> There is no place for a ship in the port: ");
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Ship get() {
        try {
            if (countShip > minShipsInPier) {
                notifyAll();
                for (Ship ship : shipList) {
                    countShip--;
                    System.out.println(shipList.size() + "- The ship is taken from the port: ");
                    shipList.remove(ship);
                    return ship;
                }
            }
            System.out.println("0 < There are no ships in the port");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run() {
        for (int i = 0; i < shipList.size(); i++) {
            add(shipList.get(i), shipList.get(i).getNumberShip());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}