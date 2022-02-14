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
    public Boolean call() {
        while (true) {
            int cargo = ship.getCargo(port); //берем груз с корабля
            if (cargo == 0 || cargo == port.getCargoMaxCount()) {
                break;
            }
            //if (!port.isFull()) {
            if(port.getCountCargo() < port.getCargoMaxCount()){
                port.setCountCargo(port.getCountCargo() + cargo); //кладем груз в порт, проверяя его максимальную грузоподъемность
            }
        }
        return true;
    }
}