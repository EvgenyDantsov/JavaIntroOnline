package com.evgeny.unit;

//Задание 4. Многопоточность. Порт . Корабли заходят в порт для разгрузки/загрузки контейнеров.
// Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным
// и превышающим заданную грузоподъемность судна и вместимость порта. В порту работает несколько причалов.
// У одного причала может стоять один корабль. Корабль может загружаться у причала или разгружаться.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Port port = new Port(5);

        //ShipGenerator shipGenerator = new ShipGenerator(port, 5);

        PierLoader pierLoader1 = new PierLoader(port);
        PierLoader pierLoader2 = new PierLoader(port);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(port);
        service.execute(pierLoader1);
        service.execute(pierLoader2);

        service.shutdown();
    }
}