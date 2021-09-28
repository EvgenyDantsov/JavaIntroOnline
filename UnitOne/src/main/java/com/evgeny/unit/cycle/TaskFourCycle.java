package com.evgeny.unit.cycle;

//Составить программу нахождения произведения квадратов первых двухсот чисел.

import java.math.BigDecimal;

public class TaskFourCycle {
    public static void main(String[] args) {
        BigDecimal p = BigDecimal.valueOf(1);
        for (int i = 2; i <= 200; i++) {
            p = p.multiply(BigDecimal.valueOf((long) i * i));
        }
        System.out.println("Произведение квадратов первых двухсот чисел p: " + p);
    }
}
