package com.evgeny.unit;

import java.util.concurrent.Callable;

public class UnloadShip implements Callable<Boolean> {

    private Ships ship;
    private Ports port;

    public UnloadShip(Ships ship, Ports port) {
        this.port = port;
        this.ship = ship;
    }

    @Override
    public Boolean call() {
        while (true){
           int cargo = ship.getCargo(port);
            if(cargo == 0){
                break;
            }
            port.setCountCargo(port.getCountCargo() + cargo);
        }
       return true;
    }
}