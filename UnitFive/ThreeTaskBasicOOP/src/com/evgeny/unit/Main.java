package com.evgeny.unit;

//Создать класс Календарь с внутренним классом, с помощью объектов которого
// можно хранить информацию о выходных и праздничных днях.

public class Main {
    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        Calendar.WeekendAndHolidays weekendAndHolidays = calendar.new WeekendAndHolidays();
        weekendAndHolidays.menu();
    }
}
