package com.evgeny.unit.ship;

import com.evgeny.unit.port.Port;

import java.util.Random;

public class Ship {
    private String name;
    private int cargoMaxCountShip;
    private int actionShip;
    private Port port;
    private int cargoShip;

    public Ship(String name) {
        this.name = name;
        this.cargoMaxCountShip = getRandomSize();
        this.actionShip = getRandom();
        if(actionShip == 1){
            this.cargoShip = getCargoMaxCountShip();
        } else {
            this.cargoShip = 0;
        }
        System.out.println("Name ship: " + getName() + "cargoShip: " + cargoShip + " , maxCountCargo: " + cargoMaxCountShip);
    }
    public Ship(String name, int cargoMaxCountShip, int actionShip) {
        this.name = name;
        this.cargoMaxCountShip = cargoMaxCountShip;
       // System.out.println("Name ship: " + getName() + ", maxCountCargo: " + cargoMaxCountShip);
        this.actionShip = actionShip;
        if(actionShip == 1){
            this.cargoShip = getCargoMaxCountShip();
        } else {
            this.cargoShip = 0;
        }
        System.out.println("Name ship: " + getName() + "cargoShip: " + cargoShip + " , maxCountCargo: " + cargoMaxCountShip);
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

    public int getActionShip() {
        return actionShip;
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

    synchronized public int getCargo(Port port) throws InterruptedException {
        int bufferCargo = 0;
        if (port.getCargoPort().intValue() < port.getCargoMaxCountPort()) {
            if (getCargoShip() != 0) {
                if ((port.getCargoMaxCountPort() - port.getCargoPort().intValue()) - getCargoShip() >= 0) {
                    bufferCargo = getCargoShip();
                    System.out.println("port shippend countCargo:" + port.getCargoPort());
                } else if(getCargoShip() > (port.getCargoMaxCountPort() - port.getCargoPort().intValue()) && port.getCargoPort().intValue() < port.getCargoMaxCountPort()) {
                    bufferCargo = port.getCargoMaxCountPort() - port.getCargoPort().intValue();
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
            Thread.sleep(2000);
            System.out.println("The port " + port.getName() + " is full");
            return 0;
        }
    }

    private int getRandomSize() {
        Random random = new Random();
        Size sizeShip = Size.values()[random.nextInt(Size.values().length)];
        return sizeShip.getValue();
    }

    private int getRandom() {
        return (int) (Math.random() * 2);
    }
}