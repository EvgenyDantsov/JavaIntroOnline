package com.evgeny.unit;

import java.util.Random;

public class Ships {
    private String name;
    private int cargoMaxCount;
    private Ports port;
    private int cargoShip;

    public Ships(String name) {
        this.name = name;
        this.cargoMaxCount = getRandomSize();
        System.out.println(cargoMaxCount);
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

    public Ports getPort() {
        return port;
    }

    public void setPort(Ports port) {
        this.port = port;
    }

    synchronized public boolean isFull() {
        if (getCargoShip() < cargoMaxCount) {
            return false;
        } else return true;
    }

    synchronized public boolean putCargo(int c) {
        if (!isFull()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }
            setCargoShip(getCargoShip() + c);
            System.out.println("cargo " + c + " is add to " + name);
            System.out.println(getCargoShip() + " of " + getCargoMaxCount());
            return true;
        } else {
            System.out.println("The ship " + name + " is full");
            return false;
        }
    }

    synchronized public int getCargo(Ports port) {
        int bufferCargo = 0;
        if(!port.isFull()) {
            if (getCargoShip() != 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("ERROR");
                }
                if ((port.getCargoMaxCount() - port.getCountCargo()) - 10 >= 0 && getCargoShip() - 10 >= 0) {
                    bufferCargo = 10;
                    System.out.println("get 10: "+((port.getCargoMaxCount() - port.getCountCargo()) - 5));
                } else if ((port.getCargoMaxCount() - port.getCountCargo()) - 5 >= 0 && getCargoShip() - 5 >= 0) {
                    bufferCargo = 5;
                    System.out.println("get 5: "+((port.getCargoMaxCount() - port.getCountCargo()) - 5));
                } else if ((port.getCargoMaxCount() - port.getCountCargo()) - 1 >= 0 && getCargoShip() - 1 >= 0) {
                    bufferCargo = 1;
                    System.out.println("get 1: "+((port.getCargoMaxCount() - port.getCountCargo()) - 1));
                }
                System.out.println("cargo " + bufferCargo + " get from" + name);
                setCargoShip(getCargoShip() - bufferCargo);
                return bufferCargo;
            } else {
                System.out.println("The ship " + name + " is empty");
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