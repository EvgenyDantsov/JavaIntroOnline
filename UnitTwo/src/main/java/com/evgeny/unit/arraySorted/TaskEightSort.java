package com.evgeny.unit.arraySorted;

//Даны дроби p1/q1,p2/q2,...,pn/qn (pi, qi - натуральные). Составить программу, которая приводит эти дроби к общему
//знаменателю и упорядочивает их в порядке возрастания.

public class TaskEightSort {
    public static void main(String[] args) {

    }
}
//    public static void eighthTask(int[] arr1, int[] arr2) {
//        System.out.printf("%nAnswer eighthTask: %n");
//        System.out.print("Числители:   ");
//        printIntArray(arr1);
//        System.out.print("Знаменатели: ");
//        printIntArray(arr2);
//
//        int max = arr2[0];
//
//        for (int i = 1; i < arr2.length; i++) {
//            if (max < arr2[i]) {
//                max = arr2[i];
//            }
//        }
//        int k = 2;
//        for (int i = 0; i < arr2.length; i++) {
//            if (max % arr2[i] != 0) {
//                max = max * k;
//                k++;
//                i = 0;
//            }
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i] = arr1[i] * (max / arr2[i]);
//            arr2[i] = max;
//        }
//
//        System.out.println("Общий знаменатель равен: " + max);
//        sortIntegerArray(arr1);
//        System.out.print("Числители:   ");
//        printIntArray(arr1);
//        System.out.print("Знаменатели: ");
//        printIntArray(arr2);
//    }
//    public static void sortIntegerArray(int[] arr) {
//
//        int max;
//        int temp;
//
//        for (int i = 0; i < arr.length; i++) {
//            max = i;
//            for (int j = i; j < arr.length; j++) {
//                if (arr[max] < arr[j]) {
//                    max = j;
//                }
//            }
//            temp = arr[i];
//            arr[i] = arr[max];
//            arr[max] = temp;
//        }
//
//    }
//    static void printIntArray(int[] arr) {
//        for (int elem : arr) {
//            System.out.print(elem + " ");
//        }
//        System.out.println();
//    }
//
//}
