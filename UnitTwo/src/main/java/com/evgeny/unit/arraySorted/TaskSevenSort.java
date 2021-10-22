package com.evgeny.unit.arraySorted;

//Пусть даны две неубывающие последовательности действительных чисел a1<=a2<=...<=an и b1<=b2<=...<=bm.
//Требуется указать те места, на которые нужно вставлять элементы последовательности
// b1<=b2<=...<=bm в первую последовательность так, чтобы новая последовательность
// оставалась возрастающей.

import java.util.Scanner;

public class TaskSevenSort {
    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
//        System.out.print("Введите натуральное число n: ");
//        n = in.nextInt();
//        System.out.print("Введите натуральное число m: ");
//        m = in.nextInt();
        System.out.print("ArrayOne: ");
        int[] arrayOne = {1,3,5,7,9};
        //int[] arrayOne = new int[n];
       // randomArray(arrayOne);
        System.out.print("ArrayTwo: ");
        int[] arrayTwo = {1,2,3,4};
       // int[] arrayTwo = new int[m];
       // randomArray(arrayTwo);
        int[] arrayPlaceTwoToOne=new int[arrayTwo.length];
        //int[] arrayPlaceTwoToOne=new int[m];
        searchPlace(arrayOne,arrayTwo,arrayPlaceTwoToOne);
    }
    public static void randomArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void searchPlace(int[] arrayOne, int[] arrayTwo, int[]arrayPlaceTwoToOne){
        int index=0;
        for (int j = 0; j < arrayTwo.length; j++) {
            if(arrayOne.length>j) {
                if (arrayOne[j] >= arrayTwo[j]) {
                    arrayPlaceTwoToOne[j] = j+index;
                    index++;
                }else {
                    index++;
                    arrayPlaceTwoToOne[j] = index+j;
                }
                } else {
                index++;
                arrayPlaceTwoToOne[j] = j+index;
            }
            }
        System.out.println("С учетом количества сделанных вставок " + "\nэлементы второго массива надо расположить "
                + "\nна следующих позициях первого массива: ");
        for(int arr:arrayPlaceTwoToOne){
            System.out.print(arr+" ");
        }
        }
    }
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