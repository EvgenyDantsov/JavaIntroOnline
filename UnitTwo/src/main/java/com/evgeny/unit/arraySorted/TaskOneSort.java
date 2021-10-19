package com.evgeny.unit.arraySorted;

//Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
//один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
//дополнительный массив.

import java.util.Scanner;

public class TaskOneSort {
    public static void main(String[] args) {
        int k, i=0,j=0;
        int[] arrayOne=new int[5];
        int[] arrayTwo=new int[3];
        int[] arrayGeneral=new int[arrayOne.length+arrayTwo.length];
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Введите натуральное число k: ");
            k = in.nextInt();
        }while(k<0&&k>arrayOne.length);
        System.out.print("ArrayOne: ");
        printArray(arrayOne);
        System.out.print("ArrayTwo: ");
        printArray(arrayTwo);
        System.out.print("ArrayGeneral: ");
        for(int n=0; n<arrayGeneral.length;n++){
            if(n<k) {
                arrayGeneral[n] = arrayOne[i];
                i++;
            }else if(j<arrayTwo.length)
            {
                arrayGeneral[n] = arrayTwo[j];
                j++;
            }else {
                arrayGeneral[n] = arrayOne[i];
                i++;
            }
            System.out.print(arrayGeneral[n] + " ");
        }
    }
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
                arr[i] = (int) (Math.random() * 10);
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
}
