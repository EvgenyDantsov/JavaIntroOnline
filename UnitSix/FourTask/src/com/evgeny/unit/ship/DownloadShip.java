package com.evgeny.unit.ship;

import com.evgeny.unit.port.Port;

import java.util.concurrent.Callable;

public class DownloadShip implements Callable<Boolean> {

    private Ship ship;
    private Port port;

    public DownloadShip(Ship ship, Port port) {
        this.ship = ship;
        this.port = port;
    }

    @Override
    public Boolean call() {
        while (true) {
           // System.out.println("download NameThread: "+ Thread.currentThread().getName() + ". nameShip: " + ship.getName());
            int cargo = port.getCargo(ship); //берем груз с порта
            if (cargo != 0) {
                ship.putCargo(cargo);//кладем груз на корабль
            } else {
                break;
            }
        }
        return true;
    }
}