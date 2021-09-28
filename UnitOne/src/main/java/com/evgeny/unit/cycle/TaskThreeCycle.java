package com.evgeny.unit.cycle;

//Найти сумму квадратов первых ста чисел.

public class TaskThreeCycle {
    public static void main(String[] args) {
        int sum=0;
        for(int i=1;i<=100;i++)
        {
         sum=sum+i*i;
        }
        System.out.println("sum: "+sum);
    }
}
