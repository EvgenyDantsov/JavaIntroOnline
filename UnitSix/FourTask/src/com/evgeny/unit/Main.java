package com.evgeny.unit;

//Задание 4. Многопоточность. Порт . Корабли заходят в порт для разгрузки/загрузки контейнеров.
// Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным
// и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
// У одного причала может стоять один корабль. Корабль может загружаться у причала или разгружаться.

import com.evgeny.unit.port.Port;
import com.evgeny.unit.ship.Ship;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Port port1 = new Port("Caribbean", 3, 160, 0);
//        Port port2 = new Port("Peru", 2, 80, 0);
        //проверим, что у нас  лежит в портах
        System.out.println("In port " + port1.getName() + " is " + port1.getCargoPort() + " cargos");
//        System.out.println("In port " + port2.getName() + " is " + port2.getCargoPort() + " cargos");
        System.out.println();
        //создадим корабли
        Ship ship1 = new Ship("Ship 1");
        Ship ship2 = new Ship("Ship 2");
        Ship ship3 = new Ship("Ship 3");
        Ship ship4 = new Ship("Ship 4");
        //отправим корабли на Карибы
        port1.putShipToPort(ship1);
        port1.putShipToPort(ship2);
        port1.putShipToPort(ship3);
        port1.putShipToPort(ship4);
        //заргузим корабли
        //port1.downloadAllShipsInPort();
        port1.loadOrUnloadShipsInPort();
        System.out.println();
        System.out.println("---------------------");
        System.out.println(ship1.getName() + " cargo: " + ship1.getCargoShip());
        System.out.println(ship2.getName() + " cargo: " + ship2.getCargoShip());
        System.out.println(ship3.getName() + " cargo: " + ship3.getCargoShip());
        System.out.println(ship4.getName() + " cargo: " + ship4.getCargoShip());
        System.out.println("---------------------");
        //корабли приплыли в Перу
//        port2.putShipToPort(ship1);
//        port2.putShipToPort(ship2);
//        port2.putShipToPort(ship3);
//        port2.putShipToPort(ship4);
//        port2.putShipToPort(ship5);
//        //разгрузим корабли
//        port2.UnloadAllShipsInPort();
//        System.out.println();
//        //проверим, что теперь лежит в портах
//        System.out.println("---------------------");
//        System.out.println(ship1.getName() + " cargo: " + ship1.getCargoShip());
//        System.out.println(ship2.getName() + " cargo: " + ship2.getCargoShip());
//        System.out.println(ship3.getName() + " cargo: " + ship3.getCargoShip());
//        System.out.println(ship4.getName() + " cargo: " + ship4.getCargoShip());
//        System.out.println(ship5.getName() + " cargo: " + ship5.getCargoShip());
        System.out.println("In port " + port1.getName() + " is " + port1.getCargoPort() + " cargos");
//        System.out.println("In port " + port2.getName() + " is " + port2.getCargoPort() + " cargos");
    }
}