package com.evgeny.unit.port;

import com.evgeny.unit.ship.LoadShip;
import com.evgeny.unit.ship.Ship;
import com.evgeny.unit.ship.UnloadShip;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Port {
    private String name;
    private int docCount;
    private int cargoPort;
    private int cargoMaxCountPort;
    private ArrayList<Ship> shipList = new ArrayList<Ship>();

    public Port(String name, int docCount, int cargoMaxCountPort, int cargoPort) {
        this.name = name;
        this.docCount = docCount;
        this.cargoPort = cargoPort;
        this.cargoMaxCountPort = cargoMaxCountPort;
    }

    public String getName() {
        return name;
    }

    public int getCargoPort() {
        return cargoPort;
    }

    public int getCargoMaxCountPort() {
        return cargoMaxCountPort;
    }

    public void setCountCargoPort(int countCargoPort) {
        this.cargoPort = countCargoPort;
    }

    synchronized public int getCargo(Ship ship) {
        int buffer = 0;
        if (ship.getCargoShip() < ship.getCargoMaxCountShip()) {
            if (getCargoPort() > 0) {
                if (getCargoPort() - ship.getCargoMaxCountShip() >= 0) {
                    buffer = ship.getCargoMaxCountShip();
                } else  if (ship.getCargoMaxCountShip() > getCargoPort()) {
                    buffer = getCargoPort();
                }
                setCountCargoPort(getCargoPort() - buffer);
                System.out.println("countCargoShip: "+ship.getCargoShip()+". count buffer:"+ buffer +" Count cargo port: " + getCargoPort() +". getCargo NameThread: " +Thread.currentThread().getName());
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
        ArrayList<LoadShip> threadList = new ArrayList<LoadShip>();
        for (int i = 0; i < shipList.size(); i++) {
            threadList.add(new LoadShip(shipList.get(i), this));
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