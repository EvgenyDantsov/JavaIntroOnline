package com.evgeny.unit;

import java.util.ArrayList;
import java.util.List;

public class Port implements Runnable{
    private List<Ship> shipList;
    private static final int minShipsInPier = 0;
    private static final int maxShipsInPier = 2;
    private int countShip = 0;

    public Port(int countsShip) {
        shipList = new ArrayList<>();
        int numberShip = 0;
        for (int i = 0; i < countsShip; i++) {
            numberShip++;
            shipList.add(new Ship(numberShip));
        }
    }

//    public synchronized void add(Ship ship, int numberShip) {
//        try {
//            if (countShip < maxShipsInPier) {
//                notifyAll();
//                String info = String.format("%s + The ship arrived in the port: %s Ship %s", shipList.size(), ship.getSize(), numberShip);
//                System.out.println(info);
//                countShip++;
//            } else {
//                System.out.println(shipList.size() + "> There is no place for a ship in the port: ");
//                wait();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
    public synchronized Ship get(){
        for(Ship ship :shipList){
            return ship;
        }
        return null;
    }

    public synchronized Ship get(Ship ships, int numberShip) {
        try {
            if (countShip > minShipsInPier && countShip < maxShipsInPier) {
                notifyAll();
                for (Ship ship : shipList) {
                        countShip--;
                        shipList.remove(ship);

                    System.out.println(shipList.size() + "- The ship is taken from the port ship" + numberShip +": ");
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
            get(shipList.get(i), shipList.get(i).getNumberShip());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}