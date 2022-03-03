package com.evgeny.unit.ship;

import com.evgeny.unit.port.Port;

import java.util.concurrent.Callable;

public class UnloadShip implements Callable<Boolean> {

    private Ship ship;
    private Port port;

    public UnloadShip(Ship ship, Port port) {
        this.port = port;
        this.ship = ship;
    }

    @Override
    public Boolean call() throws InterruptedException {
        //Thread.sleep(2000);
        while (true) {
            if(port.getDocCount() > port.getDocCountBusy().intValue()) {
                port.getDocCountBusy().incrementAndGet();
            int cargo = ship.getCargo(port); //берем груз с корабля
            if (cargo == 0 || port.getCargoPort().intValue() == port.getCargoMaxCountPort()) {
                break;
            }
            //if (!port.isFull()) {
            if(port.getCargoPort().intValue() < port.getCargoMaxCountPort()){
                port.getCargoPort().set(port.getCargoPort().intValue() + cargo); //кладем груз в порт, проверяя его максимальную грузоподъемность
                if(ship.getCargoShip() == 0){
                    port.getDocCountBusy().decrementAndGet();
                }
            }
        }else {
                Thread.sleep(1000);
            }
        }
        return true;
    }
}