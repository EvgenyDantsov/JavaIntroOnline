package com.evgeny.unit;

import java.time.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Calendar {
    private final Set<MonthDay> holidays = new HashSet<>();
    Scanner in = new Scanner(System.in);

    public Calendar() {
        this.holidays.add(MonthDay.of(Month.JANUARY, 1));
        this.holidays.add(MonthDay.of(Month.JANUARY, 2));
        this.holidays.add(MonthDay.of(Month.JANUARY, 7));
        this.holidays.add(MonthDay.of(Month.MARCH, 8));
        this.holidays.add(MonthDay.of(Month.MAY, 1));
        this.holidays.add(MonthDay.of(Month.MAY, 9));
        this.holidays.add(MonthDay.of(Month.JULY, 3));
        this.holidays.add(MonthDay.of(Month.NOVEMBER, 7));
        this.holidays.add(MonthDay.of(Month.DECEMBER, 25));
    }

    public class WeekendAndHolidays {

        public boolean isHoliday(LocalDate localDate) {   //проверка выходной или праздничный день
            return isWeekend(localDate) || holidays.contains(dayMonth(localDate));
        }

        public void printWeekendAndHoliday(LocalDate startMonth, LocalDate endMonth) { // вывод количества праздничных и выходных дней
            System.out.println("Total weekends and holidays: " + numberOfWeekendAndHoliday(startMonth, endMonth));
            for (LocalDate date = startMonth; !date.isAfter(endMonth); date = date.plusDays(1)) {
                if (isHoliday(date)) {
                    System.out.println(date + "  " + date.getDayOfWeek());
                }
            }
        }

        public int numberOfWeekendAndHoliday(LocalDate startMonth, LocalDate endMonth) { //подсчет количества выходных и праздничных дней
            int count = 0;
            for (LocalDate date = startMonth; !date.isAfter(endMonth); date = date.plusDays(1)) {
                if (isHoliday(date)) {
                    count++;
                }
            }
            return count;
        }

        public void menu() {
            int choice;
            while (true) {
                System.out.print("Select an action:" + "\n0. Exit" + "\n1. See the count of holidays and weekends " + "\nSelect: ");
                choice = in.nextInt();
                if (choice == 0) {
                    break;
                }
                if (choice < 1 || choice > 2) {
                    System.out.println("Incorrect menu item selected, reenter.");
                    continue;
                }
                if (choice == 1) {
                    int months, daysInMonth;
                    System.out.print("List month:\n");
                    for (Month month : Month.values()) {
                        System.out.println(month.getValue() + ". " + month);
                    }
                    System.out.print("Select month: ");
                    months = in.nextInt();
                    YearMonth yearMonthObject = YearMonth.of(LocalDate.now().getYear(), months);
                    daysInMonth = yearMonthObject.lengthOfMonth();
                    printWeekendAndHoliday(LocalDate.of(LocalDate.now().getYear(), months, 1), LocalDate.of(LocalDate.now().getYear(), months, daysInMonth));
                    break;
                }
            }
        }

        public boolean isWeekend(LocalDate localDate) { //проверка день недели суббота или воскресенье
            final DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }

        public MonthDay dayMonth(LocalDate localDate) {
            return MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        }
    }
}
