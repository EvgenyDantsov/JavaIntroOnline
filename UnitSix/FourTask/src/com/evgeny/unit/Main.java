package com.evgeny.unit;

//Задание 4. Многопоточность. Порт . Корабли заходят в порт для разгрузки/загрузки контейнеров.
// Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным
// и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
// У одного причала может стоять один корабль. Корабль может загружаться у причала или разгружаться.

import com.evgeny.unit.port.Port;
import com.evgeny.unit.ship.Ship;

public class Main {

    public static void main(String[] args) {
        Port port1 = new Port("Caribbean", 10, 80, 70);
        Port port2 = new Port("Peru", 2, 40, 0);
        //проверим, что у нас  лежит в портах
        System.out.println("In port " + port1.getName() + " is " + port1.getCountCargo() + " cargos");
        System.out.println("In port " + port2.getName() + " is " + port2.getCountCargo() + " cargos");
        System.out.println();
        //создадим корабли
        Ship ship1 = new Ship("Ice 1");
        Ship ship2 = new Ship("Ice 2");
        Ship ship3 = new Ship("Ice 3");
        Ship ship4 = new Ship("Ice 4");
        //отправим корабли на Карибы
        port1.putShipToPort(ship1);
        port1.putShipToPort(ship2);
        port1.putShipToPort(ship3);
        port1.putShipToPort(ship4);
        //заргузим корабли
        port1.downloadAllShipsInPort();
        System.out.println();
        //корабли приплыли в Перу
        port2.putShipToPort(ship1);
        port2.putShipToPort(ship2);
        port2.putShipToPort(ship3);
        port2.putShipToPort(ship4);
        //разгрузим корабли
        port2.UnloadAllShipsInPort();
        System.out.println();
        //проверим, что теперь лежит в портах
        System.out.println("In port " + port1.getName() + " is " + port1.getCountCargo() + " cargos");
        System.out.println("In port " + port2.getName() + " is " + port2.getCountCargo() + " cargos");
    }
}