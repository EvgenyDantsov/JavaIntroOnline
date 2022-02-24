package com.evgeny.unit.ship;

import com.evgeny.unit.port.Port;

import java.util.Random;

public class Ship {
    private String name;
    private int cargoMaxCountShip;
    private Port port;
    private int cargoShip;

    public Ship(String name) {
        this.name = name;
        this.cargoMaxCountShip = getRandomSize();
        System.out.println("Name ship: " + getName() + ", maxCountCargo: " + cargoMaxCountShip);
        this.cargoShip = 0;
    }
    public Ship(String name, int cargoMaxCountShip) {
        this.name = name;
        this.cargoMaxCountShip = cargoMaxCountShip;
        System.out.println("Name ship: " + getName() + ", maxCountCargo: " + cargoMaxCountShip);
        this.cargoShip = 0;
    }

    public String getName() {
        return name;
    }

    public int getCargoMaxCountShip() {
        return cargoMaxCountShip;
    }

    public int getCargoShip() {
        return cargoShip;
    }

    public void setCargoShip(int cargoShip) {
        this.cargoShip = cargoShip;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    synchronized public boolean putCargo(int c) {
        if (getCargoShip() < cargoMaxCountShip) {
            setCargoShip(getCargoShip() + c);
            System.out.println("cargo " + c + " moved to ship name " + name + ". NameThread: " + Thread.currentThread().getName());
            System.out.println("cargo " + c + " moved from port \"" + port.getName() + "\" to ship name \"" + name + "\"");
            System.out.println(getCargoShip() + " of " + getCargoMaxCountShip());
            return true;
        } else {
            System.out.println("The ship " + name + " is full");
            return false;
        }
    }

    synchronized public int getCargo(Port port) {
        int bufferCargo = 0;
        if (port.getCargoPort() < port.getCargoMaxCountPort()) {
            if (getCargoShip() != 0) {
                if ((port.getCargoMaxCountPort() - port.getCargoPort()) - getCargoShip() >= 0) {
                    bufferCargo = getCargoShip();
                    System.out.println("port shippend countCargo:" + port.getCargoPort());
                } else if(getCargoShip() > (port.getCargoMaxCountPort() - port.getCargoPort()) && port.getCargoPort() < port.getCargoMaxCountPort()) {
                    bufferCargo = port.getCargoMaxCountPort() - port.getCargoPort();
                }
                System.out.println("cargo " + bufferCargo + " shipped from ship \"" + name + "\" to port \"" + port.getName() + "\", portCargo: " + port.getCargoPort() + ". NameThread: " + Thread.currentThread().getName());
                setCargoShip(getCargoShip() - bufferCargo);
                System.out.println("countCargo " + getName() + ": " + getCargoShip());
                return bufferCargo;
            } else {
                System.out.println("The ship " + name + " is empty" + " countCargo:" + cargoShip);
                return 0;
            }
        } else {
            System.out.println("The port " + port.getName() + " is full");
            return 0;
        }
    }

    private int getRandomSize() {
        Random random = new Random();
        Size sizeShip = Size.values()[random.nextInt(Size.values().length)];
        return sizeShip.getValue();
    }
}