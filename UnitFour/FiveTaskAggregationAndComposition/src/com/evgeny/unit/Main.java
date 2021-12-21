package com.evgeny.unit;

//Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
// различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
// Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.

public class Main {

    public static void main(String[] args) {
        CreateFile cf = new CreateFile();
        Tours tours = new Tours(cf.searchFile());
        tours.menu();
    }
}
