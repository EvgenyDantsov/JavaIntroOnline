package com.evgeny.unit;

//Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
// счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление
// суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.

public class Main {

    public static void main(String[] args) {
	Bank bank = new Bank();
    bank.menu();
    }
}