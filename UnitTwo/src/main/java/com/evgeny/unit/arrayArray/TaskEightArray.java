package com.evgeny.unit.arrayArray;

//В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
//на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
//пользователь с клавиатуры.

import java.util.Scanner;

public class TaskEightArray {
    public static void main(String[] args) {
        int n = 5, oneColumn, twoColumn, temp;
        Scanner in = new Scanner(System.in);
        int[][] array = new int[n][n];
        System.out.println("Array[" + n + "][" + n + "]: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("Введите номер первого столбца матрицы: ");
        oneColumn = in.nextInt();
        System.out.print("Введите номер второго столбца матрицы: ");
        twoColumn = in.nextInt();
        System.out.println("Матрица в которой поменяли местами столбцы " + oneColumn + " и " + twoColumn + ": ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (oneColumn - 1 == j) {
                    temp = array[i][oneColumn - 1];
                    array[i][oneColumn - 1] = array[i][twoColumn - 1];
                    array[i][twoColumn - 1] = temp;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}