package com.evgeny.unit.port;

import com.evgeny.unit.ship.DownloadShip;
import com.evgeny.unit.ship.Ship;
import com.evgeny.unit.ship.UnloadShip;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {
    private String name;
    private int docCount;
    private int countCargo;
    private int cargoMaxCount;
    private ArrayList<Ship> shipList = new ArrayList<Ship>();

    public int getCargoMaxCount() {
        return cargoMaxCount;
    }

    public Port(String name, int docCount, int cargoMaxCount, int countCargo) {
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

    synchronized public int getCargo(Ship ship) {
        int buffer = 0;
        //if (!ship.isFull()) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
        if (ship.getCargoShip() < ship.getCargoMaxCount()) {
            if (getCountCargo() > 0) {
                if (getCountCargo() - 10 >= 0 && (ship.getCargoMaxCount() - ship.getCargoShip()) - 10 >= 0) {
                    buffer = 10;
                } else if (getCountCargo() - 5 >= 0 && (ship.getCargoMaxCount() - ship.getCargoShip()) - 5 >= 0) {
                    buffer = 5;
                } else if (getCountCargo() - 1 >= 0 && (ship.getCargoMaxCount() - ship.getCargoShip()) - 1 >= 0) {
                    buffer = 1;
                }
                setCountCargo(getCountCargo() - buffer);
               // System.out.println("countCargoShip: "+ship.getCargoShip()+". count buffer:"+ buffer +" Count cargo port: " + getCountCargo() +". getCargo NameThread: " +Thread.currentThread().getName());
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

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

    public int getDocCount() {
        return docCount;
    }

    public void putShipToPort(Ship s) {
        shipList.add(s);
        s.setPort(this);
        System.out.println("The ship " + s.getName() + " ship came to port " + name);
    }

    //метод который загрузит все корабли которые на данный момент находятся в  порту
    public void downloadAllShipsInPort() {
        ExecutorService ex;
        if (shipList.size() <= getDocCount()) {
            ex = Executors.newFixedThreadPool(shipList.size());
        } else {
            ex = Executors.newFixedThreadPool(getDocCount());
        }
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
        ExecutorService ex;
        if (shipList.size() <= getDocCount()) {
            ex = Executors.newFixedThreadPool(shipList.size());
        } else {
            ex = Executors.newFixedThreadPool(getDocCount());
        }
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