package com.evgeny.unit.arraySorted;

//Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
//Делается это следующим образом: сравниваются два соседних элемента ai и a(i+1). Если ai<=a(i+1), то продвигаются
//на один элемент вперед. Если ai>a(i+1), то производится перестановка и сдвигаются на один элемент назад.
//Составить алгоритм этой сортировки.

public class TaskSixSort {
    public static void main(String[] args) {

    }
}
//    public static double[] sixthTask(double[] arr) {
//        System.out.printf("%nAnswer sixthTask: %n");
//        printDoubleArray(arr);
//
//        double temp;
//        int i = 0;
//
//        while (i < arr.length - 1) {
//            if (arr[i] <= arr[i + 1]) {
//                i++;
//            } else {
//                temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//                i = i == 0 ? 0 : i - 1;
//            }
//        }
//
//        printDoubleArray(arr);
//        return arr;
//    }
//    static void printDoubleArray(double[] arr) {
//        for (double elem : arr) {
//            System.out.print(elem + " ");
//        }
//        System.out.println();
//    }
