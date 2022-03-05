package com.evgeny.unit.ship;

import com.evgeny.unit.port.Port;

import java.util.concurrent.Callable;

//public class LoadShip implements Callable<Boolean> {
public class LoadShip implements Runnable {
    private Ship ship;
    private Port port;

    public LoadShip(Ship ship, Port port) {
        this.ship = ship;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                if (port.getDocCount() > port.getDocCountBusy().intValue()) {
                    if (port.getCargoPort().intValue() != 0 && port.getCountShipUnload() != 0) {
                        port.getDocCountBusy().incrementAndGet();
                        int cargo = port.getCargo(ship); //берем груз с порта
                        if (cargo != 0) {
                            ship.putCargo(cargo);//кладем груз на корабль
                            if (ship.getCargoShip() == ship.getCargoMaxCountShip()) {
                                port.getDocCountBusy().decrementAndGet();
                                port.setCountShipLoad(port.getCountShipLoad() - 1);
                                break;
                            } else {
                                if (port.getCountShipUnload() > 0) {
                                    port.getDocCountBusy().decrementAndGet();
                                    Thread.sleep(1000);
                                } else if (port.getCargoPort().intValue() != 0) {
                                    Thread.sleep(1000);
                                } else {
                                    break;
                                }
                            }
                        } else {
                            port.getDocCountBusy().decrementAndGet();
                            Thread.sleep(1000);
                        }
                    } else {
                        break;
                    }
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("---");
        }
        System.out.println("In portL " + port.getName() + " is " + port.getCargoPort() + " cargos");
    }
//    @Override
//    public Boolean call() throws InterruptedException {
//        while (true) {
//           // System.out.println("download NameThread: "+ Thread.currentThread().getName() + ". nameShip: " + ship.getName());
//           // Thread.sleep(2000);
//            if(port.getDocCount() > port.getDocCountBusy().intValue()) {
//                port.getDocCountBusy().incrementAndGet();
//                int cargo = port.getCargo(ship); //берем груз с порта
//                if (cargo != 0) {
//                    ship.putCargo(cargo);//кладем груз на корабль
//                    if(ship.getCargoShip() == ship.getCargoMaxCountShip()){
//                        port.getDocCountBusy().decrementAndGet();
//                    }
//                } else {
//                    break;
//                }
//            }else Thread.sleep(1000);
//        }
//        return true;
//    }
}