package com.evgeny.unit.arraySorted;

//Пусть даны две неубывающие последовательности действительных чисел a1<=a2<=...<=an и b1<=b2<=...<=bm.
//Требуется указать те места, на которые нужно вставлять элементы последовательности b1<=b2<=...<=bm2 в первую
//последовательность так, чтобы новая последовательность оставалась возрастающей.

public class TaskSevenSort {
    public static void main(String[] args) {

    }
}
//    public static void seventhTask(int[] arr1, int[] arr3) {
//        System.out.printf("%nAnswer seventhTask: %n");
//        printIntArray(arr1);
//        printIntArray(arr3);
//
//        int[] arr = new int[arr3.length];
//        int n;
//
//        for (int j = 0; j < arr3.length; j++) {
//            n = binarySearch(arr1, 0, arr1.length - 1, arr3[j]);
//            arr[j] = n + j + 1;
//        }
//
//        System.out.println("С учетом количества сделанных вставок " + "\nэлементы второго массива надо расположить "
//                + "\nна следующих позициях первого массива: ");
//        printIntArray(arr);
//    }
//    static void printIntArray(int[] arr) {
//        for (int elem : arr) {
//            System.out.print(elem + " ");
//        }
//        System.out.println();
//    }
//    static int binarySearch(int arr[], int start, int end, int elem) {
//
//        int mid = start + (end - start) / 2;
//
//        if (elem < arr[start]) {
//            return -1;
//        }
//        if (elem > arr[end]) {
//            return end;
//        }
//        if (arr[mid] < elem && elem <= arr[mid + 1]) {
//            return mid;
//        }
//        if (arr[mid] > elem) {
//            return binarySearch(arr, start, mid - 1, elem);
//        }
//        return binarySearch(arr, mid + 1, end, elem);
//    }