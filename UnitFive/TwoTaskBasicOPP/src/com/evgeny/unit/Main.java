package com.evgeny.unit;

//Создать класс Payment с внутренним классом, с помощью объектов
// которого можно сформировать покупку из нескольких товаров.

public class Main {

    public static void main(String[] args) {
        Payment payment = new Payment();
        Payment.Market market = payment.new Market();
        market.menu();
    }
}
