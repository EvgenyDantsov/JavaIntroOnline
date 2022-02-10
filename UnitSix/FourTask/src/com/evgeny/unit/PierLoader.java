package com.evgeny.unit;

public class PierLoader implements Runnable {
    private Thread t;
    private Port port;

    public PierLoader(Port port) {
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Time to load the goods
                Thread.sleep(500);
                Ship ship = port.get();
                if(ship != null) {
                    while (ship.countCheck()) {
                        Thread.sleep(100);
                        ship.add(10);
                        System.out.println(ship.getCount() + " (" + ship.getSize().getValue() + ")" + " Loaded ship.  Ship " + ship.getNumberShip());
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void start(){
        System.out.println("start pier");
        t=new Thread();
        t.start();
    }
}