package com.evgeny.unit.arrayArray;

//Отсортировать строки матрицы по возрастанию и убыванию значений элементов.

public class TaskTwelveArray {
    public static void main(String[] args) {
        int n = 5;
        int[][] array = new int[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) ((Math.random() * 10));
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        sortUp(array);
        sortDown(array);
    }

    public static void sortUp(int[][] array) {
        int temp;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int z = 0; z < array.length - 1; z++) {
                    if (array[i][z] > array[i][z + 1]) {
                        temp = array[i][z];
                        array[i][z] = array[i][z + 1];
                        array[i][z + 1] = temp;
                    }
                }
            }
        }
        System.out.println("По возрастанию: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void sortDown(int[][] array) {
        int temp;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int z = 0; z < array.length - 1; z++) {
                    if (array[i][z] < array[i][z + 1]) {
                        temp = array[i][z];
                        array[i][z] = array[i][z + 1];
                        array[i][z + 1] = temp;
                    }
                }
            }
        }
        System.out.println("По убыванию: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}