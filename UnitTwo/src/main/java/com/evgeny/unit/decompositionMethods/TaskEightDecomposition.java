package com.evgeny.unit.decompositionMethods;

//Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
//Пояснение. Составить метод(методы) для вычисления суммы трех последовательно
// расположенных элементов массива с номерами от k до m.

import java.util.Scanner;

import static com.evgeny.unit.decompositionMethods.TaskTwoDecomposition.randomValue;

public class TaskEightDecomposition {
    public static void main(String[] args) {
        int n, k;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размер массива n: ");
        n = in.nextInt();
        int[] array = new int[n];
        do{
            System.out.print("Введите номер элемента k: ");
            k = in.nextInt();
        } while (k+3>array.length);
        randomValue(array); //используем статический метод для заполниния массива рандомными числами из класса TaskTwoDecomposition
        sumThreeSerialValue(array, k);
    }
    public static void sumThreeSerialValue(int[] array, int k){
        int sum=0, count=0;
        for(int i=k-1; i<k+2;i++){
            if(count<3){
             sum=sum+array[i];
             count++;
            }
        }
        System.out.print("Сумма трех последовательно расположеных элементов \nот " +
                +k+" до "+(k+2)+" равна: "+sum);
    }
}
