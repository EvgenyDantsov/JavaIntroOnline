package com.evgeny.unit.ship;

import com.evgeny.unit.port.Port;

import java.util.concurrent.Callable;

public class LoadShip implements Callable<Boolean> {

    private Ship ship;
    private Port port;

    public LoadShip(Ship ship, Port port) {
        this.ship = ship;
        this.port = port;
    }

    @Override
    public Boolean call() throws InterruptedException {
        while (true) {
           // System.out.println("download NameThread: "+ Thread.currentThread().getName() + ". nameShip: " + ship.getName());
           // Thread.sleep(2000);
            if(port.getDocCount() > port.getDocCountBusy().intValue()) {
                port.getDocCountBusy().incrementAndGet();
                int cargo = port.getCargo(ship); //берем груз с порта
                if (cargo != 0) {
                    ship.putCargo(cargo);//кладем груз на корабль
                    if(ship.getCargoShip() == ship.getCargoMaxCountShip()){
                        port.getDocCountBusy().decrementAndGet();
                    }
                } else {
                    break;
                }
            }else Thread.sleep(1000);
        }
        return true;
    }
}