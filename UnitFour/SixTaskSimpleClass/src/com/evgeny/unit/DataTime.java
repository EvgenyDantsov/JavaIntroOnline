package com.evgeny.unit;

import java.util.Scanner;

public class DataTime {
    private int hours, minutes, seconds;

    public DataTime(int hours, int minutes, int seconds) {
        setHour(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public DataTime(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public DataTime() {
        this(0, 0, 0);
    }

    public int getHours() {
        return hours;
    }

    public void setHour(int hours) {
        if (hours < 0 || hours > 23)
            this.hours = 0;
        else
            this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59)
            this.minutes = 0;
        else
            this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59)
            this.seconds = 0;
        else
            this.seconds = seconds;
    }

    public void print() {
        System.out.println(toString());
    }

    static DataTime read(Scanner scanner) {
        System.out.println("Установите время:");
        DataTime time = new DataTime();
        System.out.print("Введите часы: ");
        time.setHour(scanner.nextInt());
        System.out.print("Введите минуты: ");
        time.setMinutes(scanner.nextInt());
        System.out.print("Введите секунды: ");
        time.setSeconds(scanner.nextInt());
        return time;
    }

    public void addSeconds(int seconds) {
        this.seconds += seconds;
        this.minutes += this.seconds / 60;
        this.seconds = this.seconds % 60;
        this.hours += this.minutes / 60;
        this.minutes = this.minutes % 60;
        this.hours = this.hours % 24;
    }

    public void addMinutes(int minutes) {
        addSeconds(minutes * 60);
    }

    public void addHours(int hours) {
        addSeconds(hours * 60 * 60);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
