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
           Cargo cargo = ship.getCagro();
            if(cargo == null){
                break;
            }
            port.putCargoToPort(cargo);
        }
       return true;
    }
}

