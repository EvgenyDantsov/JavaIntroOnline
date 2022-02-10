package com.evgeny.unit;

import java.util.concurrent.Callable;

public class DownloadShip implements Callable<Boolean> {

        private Ships ship;
        private Ports port;

    public DownloadShip(Ships ship, Ports port) {
            this.ship = ship;
            this.port = port;
        }

        @Override
        public Boolean call() {
            while (true) {
                Cargo cargo = port.getCargo(ship); //берем груз
                if (cargo!=null) {
                    ship.putCargo(cargo);//кладем груз на корабль
                }
                else{
                    break;
                }
            }
            return true;
        }
}
