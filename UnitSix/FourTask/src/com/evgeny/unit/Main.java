package com.evgeny.unit;

//Задание 4. Многопоточность. Порт . Корабли заходят в порт для разгрузки/загрузки контейнеров.
// Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным
// и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
// У одного причала может стоять один корабль. Корабль может загружаться у причала или разгружаться.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
//        Port port = new Port(5);
//
//        PierLoader pierLoader1 = new PierLoader(port);
//        PierLoader pierLoader2 = new PierLoader(port);
//
//        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//        service.execute(port);
//        service.execute(pierLoader1);
//        service.execute(pierLoader2);
//
//        service.shutdown();
        Ports port1 = new Ports("Istanbul", 10, 60,50);
        Ports port2 = new Ports("Odessa", 2, 40,0);
       // port1.putCargoToPort(50);
        //положим в один порт товары
//        for (int i = 0; i < 50; i++){
//            port1.putCargoToPort(new Box(i+1));
//            System.out.println(port1.getCargoList().get(i).getNumber());
//        }

        //что у нас теперь лежит в портах
        System.out.println("In port " + port1.getName() + " is " + port1.getCountCargo() + " cargos");
        System.out.println("In port " + port2.getName() + " is " + port2.getCountCargo() + " cargos");

        System.out.println();

        //создадим корабли
        Ships ship1 = new Ships("Titanic1");
        Ships ship2 = new Ships("Titanic2");
        Ships ship3 = new Ships("Titanic3");

        //отправим корабли в турцию
        port1.putShipToPort(ship1);
        port1.putShipToPort(ship2);
        port1.putShipToPort(ship3);
        //заргузим корабли
        port1.downloadAllShipsInPort();

        System.out.println();

        //корабли приплыли в украину
        port2.putShipToPort(ship1);
        port2.putShipToPort(ship2);
        port2.putShipToPort(ship3);
        //разгрузим корабли
        port2.UnloadAllShipsInPort();

        System.out.println();

        //проверим что теперь лежит в портах
        System.out.println("In port " + port1.getName() + " is " + port1.getCountCargo() + " cargos");
        System.out.println("In port " + port2.getName() + " is " + port2.getCountCargo() + " cargos");
    }
}