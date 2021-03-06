package com.evgeny.unit.port;

import com.evgeny.unit.ship.LoadShip;
import com.evgeny.unit.ship.Ship;
import com.evgeny.unit.ship.UnloadShip;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Port {
    private String name;
    private int docCount;
    private AtomicInteger docCountBusy;
    private AtomicInteger cargoPort;
    private int cargoMaxCountPort;
    private int countShipLoad;
    private int countShipUnload;
    private ArrayList<Ship> shipList = new ArrayList<Ship>();

    public Port(String name, int docCount, int cargoMaxCountPort, int cargoPort) {
        this.name = name;
        this.docCount = docCount;
        this.countShipLoad = 0;
        this.countShipUnload = 0;
        this.cargoPort = new AtomicInteger(0);
        this.cargoPort.set(cargoPort);
        this.docCountBusy = new AtomicInteger(0);
        this.cargoMaxCountPort = cargoMaxCountPort;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountShipLoad() {
        return countShipLoad;
    }

    public void setCountShipLoad(int countShipLoad) {
        this.countShipLoad = countShipLoad;
    }

    public int getCountShipUnload() {
        return countShipUnload;
    }

    public void setCountShipUnload(int countShipUnload) {
        this.countShipUnload = countShipUnload;
    }

    public String getName() {
        return name;
    }

    public AtomicInteger getDocCountBusy() {
        return docCountBusy;
    }

    public AtomicInteger getCargoPort() {
        return cargoPort;
    }

    public int getCargoMaxCountPort() {
        return cargoMaxCountPort;
    }

    synchronized public int getCargo(Ship ship) throws InterruptedException {
        int buffer = 0;
        if (ship.getCargoShip() < ship.getCargoMaxCountShip()) {
            if (getCargoPort().intValue() > 0) {
                if (getCargoPort().intValue() - ship.getCargoMaxCountShip() >= 0) {
                    buffer = ship.getCargoMaxCountShip();
                } else if (ship.getCargoMaxCountShip() > getCargoPort().intValue()) {
                    buffer = getCargoPort().intValue();
                }
                getCargoPort().set(getCargoPort().intValue() - buffer);
                System.out.println("countCargoShip: " + ship.getCargoShip() + ". count buffer:" + buffer + " Count cargo port: " + getCargoPort() + ". getCargo NameThread: " + Thread.currentThread().getName());
                return buffer;
            } else {
                Thread.sleep(2000);
                //System.out.println("The port " + name + " is empty");
                return 0;
            }
        } else {
            System.out.println("The ship " + ship.getName() + " is full");
            return 0;
        }

    }

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

    public int getDocCount() {
        return docCount;
    }

    public void putShipToPort(Ship s) {
        shipList.add(s);
        s.setPort(this);
        System.out.println("The ship " + s.getName() + " ship came to port " + name);
    }

    //?????????? ?????????????? ???????????????? ?????? ?????????????? ?????????????? ???? ???????????? ???????????? ?????????????????? ??  ??????????
    public void loadOrUnloadShipsInPort() throws InterruptedException {
        int load = 0, unload = 0;
        for (int i = 0; i < shipList.size(); i++) {
            if (shipList.get(i).getActionShip() == 1) {
                unload++;
                setCountShipUnload(unload);
                Thread threadUnload = new Thread(new UnloadShip(shipList.get(i), this));
                threadUnload.start();
                threadUnload.join();
            } else {
                load++;
                setCountShipLoad(load);
                Thread threadLoad = new Thread(new LoadShip(shipList.get(i), this));
                threadLoad.start();
                threadLoad.join();
            }
        }
    }
//    public void loadOrUnloadShipsInPort() {
//        int load = 0, unload = 0;
//        ExecutorService ex;
//        if (shipList.size() <= getDocCount()) {
//        ex = Executors.newFixedThreadPool(shipList.size());
//        } else {
//            ex = Executors.newFixedThreadPool(getDocCount());
//        }
//        ArrayList<LoadShip> threadListLoad = new ArrayList<>();
//        ArrayList<UnloadShip> threadListUnload = new ArrayList<>();
//        for (int i = 0; i < shipList.size(); i++) {
//            if(shipList.get(i).getActionShip() == 1) {
//                threadListUnload.add(new UnloadShip(shipList.get(i), this));
//                ex.submit(threadListUnload.get(unload));
//                unload++;
//            }else {
//                threadListLoad.add(new LoadShip(shipList.get(i), this));
//                ex.submit(threadListLoad.get(load));
//                load++;
//            }
//        }
//        for (int i = 0; i < shipList.size(); i++) {
//            if(shipList.get(i).getActionShip() == 1) {
//                new Thread(new UnloadShip(shipList.get(i), this));
//                threadListUnload.add(new UnloadShip(shipList.get(i), this));
//                ex.submit(threadListUnload.get(unload));
//                unload++;
//            }else {
//                threadListLoad.add(new LoadShip(shipList.get(i), this));
//                ex.submit(threadListLoad.get(load));
//                load++;
//            }
//        }
//        try {
//            ex.invokeAll(threadListLoad);
//            ex.invokeAll(threadListUnload);
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        ex.shutdown();
//    }
    //?????????? ?????????????? ?????????????????? ?????? ?????????????? ?????????????? ???? ???????????? ???????????? ?????????????????? ??  ??????????
//    public void UnloadAllShipsInPort() {
//        ExecutorService ex;
//        if (shipList.size() <= getDocCount()) {
//            ex = Executors.newFixedThreadPool(shipList.size());
//        } else {
//            ex = Executors.newFixedThreadPool(getDocCount());
//        }
//        ArrayList<UnloadShip> threadList = new ArrayList<UnloadShip>();
//        for (int i = 0; i < shipList.size(); i++) {
//            threadList.add(new UnloadShip(shipList.get(i), this));
//            ex.submit(threadList.get(i));
//        }
//        try {
//            ex.invokeAll(threadList);
//        } catch (Exception e) {
//            System.out.println("Error");
//        }
//        ex.shutdown();
//    }
}