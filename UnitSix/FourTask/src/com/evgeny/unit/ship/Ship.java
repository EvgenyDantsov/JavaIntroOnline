package com.evgeny.unit.ship;

import com.evgeny.unit.port.Port;

import java.util.Random;

public class Ship {
    private String name;
    private int cargoMaxCount;
    private Port port;
    private int cargoShip;

    public Ship(String name) {
        this.name = name;
        this.cargoMaxCount = getRandomSize();
        System.out.println("Name ship: " + getName() + ", maxCountCargo: " + cargoMaxCount);
        this.cargoShip = 0;
    }

    public String getName() {
        return name;
    }

    public int getCargoMaxCount() {
        return cargoMaxCount;
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

    synchronized public boolean isFull() {
        if (getCargoShip() < cargoMaxCount) {
            return false;
        } else return true;
    }

    synchronized public boolean putCargo(int c) {
        //if(!isFull()){
        if (getCargoShip() < cargoMaxCount) {
            setCargoShip(getCargoShip() + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }
            //setCargoShip(getCargoShip() + c);
            // System.out.println("cargo " + c + " moved to ship name " + name + ". NameThread: " + Thread.currentThread().getName());
            System.out.println("cargo " + c + " moved from port \"" + port.getName() + "\" to ship name \"" + name + "\"");
            //System.out.println(getCargoShip() + " of " + getCargoMaxCount());
            return true;
        } else {
            System.out.println("The ship " + name + " is full");
            return false;
        }
    }

    synchronized public int getCargo(Port port) {
        int bufferCargo = 0;
        //if(!port.isFull()){
        if (port.getCountCargo() < port.getCargoMaxCount()) {
            if (getCargoShip() != 0) {
                if ((port.getCargoMaxCount() - port.getCountCargo()) - 10 >= 0 && getCargoShip() - 10 >= 0) {
                    bufferCargo = 10;
                    System.out.println("port shippend countCargo10:" + port.getCountCargo());
                } else if ((port.getCargoMaxCount() - port.getCountCargo()) - 5 >= 0 && getCargoShip() - 5 >= 0) {
                    bufferCargo = 5;
                    System.out.println("port shippend countCargo5:" + port.getCountCargo());
                } else if ((port.getCargoMaxCount() - port.getCountCargo()) - 1 >= 0 && getCargoShip() - 1 >= 0) {
                    bufferCargo = 1;
                    System.out.println("port shippend countCargo1:" + port.getCountCargo());
                }
                System.out.println("cargo " + bufferCargo + " shipped from ship \"" + name + "\" to port \"" + port.getName() + "\", portCargo: " + port.getCountCargo() + ". NameThread: " + Thread.currentThread().getName());
                setCargoShip(getCargoShip() - bufferCargo);
                System.out.println("countCargo " + getName() + ": " + getCargoShip());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("ERROR");
                }
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