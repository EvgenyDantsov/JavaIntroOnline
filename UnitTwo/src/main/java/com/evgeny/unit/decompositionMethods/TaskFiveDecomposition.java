package com.evgeny.unit.decompositionMethods;

//Составить программу, которая в массиве A[N] находит второе по величине число
// (вывести на печать число, которое меньше максимального элемента массива,
// но больше всех других элементов).

import java.util.Scanner;

import static com.evgeny.unit.decompositionMethods.TaskTwoDecomposition.randomValue;

public class TaskFiveDecomposition {
    public static void main(String[] args) {
        int n, lessMax = 0, maxElement = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива n: ");
        n = in.nextInt();
        int[] array = new int[n];
        randomValue(array); //используем статический метод для заполниния массива рандомными числами из задания два по декомпозици
        System.out.println("Число которое меньше максимального элемента массива," +
                "\nно больше всех других элементов: "
                + searchLessMaxElement(array, maxElement, lessMax));
    }

    public static int searchMaxElement(int[] array, int maxElement) {
        for (int i = 0; i < array.length; i++) {
            if (maxElement < array[i]) {
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    public static int searchLessMaxElement(int array[], int maxElement, int lessMax) {
        maxElement = searchMaxElement(array, maxElement);
        for (int arr : array) {
            if (maxElement > lessMax && lessMax < arr && maxElement != arr) {
                lessMax = arr;
            }
        }
        return lessMax;
    }
}
