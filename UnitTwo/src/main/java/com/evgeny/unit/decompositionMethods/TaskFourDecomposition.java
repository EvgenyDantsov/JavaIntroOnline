package com.evgeny.unit.decompositionMethods;

//На плоскости заданы своими координатами n точек.
// Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние.
// Указание. Координаты точек занести в массив.

import java.util.Scanner;

public class TaskFourDecomposition {
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество точек n: ");
        n = in.nextInt();
        int[] arrayX = new int[n];
        int[] arrayY = new int[n];
        System.out.print("Координаты точек: ");
        randomValue(arrayX, arrayY);
        searchMaxDistanceBetweenPoint(arrayX,arrayY);
    }
    public static void randomValue(int[] arrayX, int[] arrayY) {
        for (int i = 0; i < arrayX.length; i++) {
            arrayX[i] = (int) (Math.random() * 10) + 1;
            arrayY[i] = (int) (Math.random() * 10) + 1;
            System.out.print("(" + arrayX[i] +"; "+arrayY[i]+") ");
        }
        System.out.println();
    }
    public static void searchMaxDistanceBetweenPoint(int[] arrayX, int[] arrayY){
        double max, maxDistance=0;
        int onePoint=0, twoPoint=1;
        for(int i=0; i<arrayX.length; i++){
            for(int j=1; j<arrayX.length; j++){
                max= Math.sqrt(Math.pow(arrayX[i]-arrayX[j],2)+Math.pow(arrayY[i]-arrayY[j],2));
                if(max>maxDistance){
                    maxDistance=max;
                    onePoint=i;
                    twoPoint=j;
                }
            }
        }
        System.out.print("Между точками ("+arrayX[onePoint]+"; "+arrayY[onePoint]+
                ") и ("+arrayX[twoPoint]+"; "+arrayY[twoPoint]+") максимальное расстояние: "+maxDistance);
    }
}
