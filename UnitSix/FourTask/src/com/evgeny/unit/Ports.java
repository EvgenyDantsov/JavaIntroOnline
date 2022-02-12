package com.evgeny.unit;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ports {
    private String name;
    private int docCount;
    private int countCargo;
    private int cargoMaxCount;
    private ArrayList<Ships> shipList = new ArrayList<Ships>();

    public int getCargoMaxCount() {
        return cargoMaxCount;
    }

    public Ports(String name, int docCount, int cargoMaxCount, int countCargo) {
        this.name = name;
        this.docCount = docCount;
        this.countCargo = countCargo;
        this.cargoMaxCount = cargoMaxCount;
    }

    public String getName() {
        return name;
    }

    public int getCountCargo() {
        return countCargo;
    }

    public void setCountCargo(int countCargo) {
        this.countCargo = countCargo;
    }

    synchronized public boolean isFull() {
        if (getCountCargo() < cargoMaxCount) {
            return false;
        } else return true;
    }

    synchronized public int getCargo(Ships ship) {
        int buffer = 0;
        if (!ship.isFull()) {
            if (countCargo >= 0) {
                if (getCountCargo() - 10 >= 0 && (ship.getCargoMaxCount() - ship.getCargoShip()) - 10 >= 0) {
                    buffer = 10;
                } else if (getCountCargo() - 5 >= 0 && (ship.getCargoMaxCount() - ship.getCargoShip()) - 5 >= 0) {
                    buffer = 5;
                } else if (getCountCargo() - 1 >= 0 && (ship.getCargoMaxCount() - ship.getCargoShip()) - 1 >= 0) {
                    buffer = 1;
                }
                setCountCargo(getCountCargo() - buffer);
                return buffer;
            } else {
                System.out.println("The port " + name + " is empty");
                return 0;
            }
        } else {
            System.out.println("The ship " + ship.getName() + " is full");
            return 0;
        }

    }

    public ArrayList<Ships> getShipList() {
        return shipList;
    }

    public int getDocCount() {
        return docCount;
    }

    public void putShipToPort(Ships s) {
        shipList.add(s);
        s.setPort(this);
        System.out.println("The ship " + s.getName() + " ship came to port " + name);
    }

    //метод который загрузит все корабли которые на данный момент находятся в  порту
    public void downloadAllShipsInPort() {
        ExecutorService ex = Executors.newFixedThreadPool(docCount);
        ArrayList<DownloadShip> threadList = new ArrayList<DownloadShip>();
        for (int i = 0; i < shipList.size(); i++) {
            threadList.add(new DownloadShip(shipList.get(i), this));
            ex.submit(threadList.get(i));
        }
        try {
            ex.invokeAll(threadList);
        } catch (Exception e) {
            System.out.println("Error");
        }
        ex.shutdown();
    }

    //метод который разгрузит все корабли которые на данный момент находятся в  порту
    public void UnloadAllShipsInPort() {
        ExecutorService ex = Executors.newFixedThreadPool(docCount);
        ArrayList<UnloadShip> threadList = new ArrayList<UnloadShip>();
        for (int i = 0; i < shipList.size(); i++) {
            threadList.add(new UnloadShip(shipList.get(i), this));
            ex.submit(threadList.get(i));
        }
        try {
            ex.invokeAll(threadList);
        } catch (Exception e) {
            System.out.println("Error");
        }
        ex.shutdown();
    }
}
