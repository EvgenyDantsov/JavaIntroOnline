package com.evgeny.unit.oneArray;

//Дан целочисленный массив с количеством элементов n.
// Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями).
// Примечание. Дополнительный массив не использовать.

import java.util.Scanner;

public class TaskTen {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        n = in.nextInt();
        int[] array = new int[n];
        System.out.print("Array[" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            System.out.print(array[i] + " ");
        }
        System.out.println("\nСжатый массив: ");
        for(int i = 0; i < array.length; i++)
        {
            if(i%2!=0) {
                array[i]=0;
            }
            System.out.print(array[i] + " ");
        }
    }
}
