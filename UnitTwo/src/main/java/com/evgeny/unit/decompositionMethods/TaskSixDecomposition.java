package com.evgeny.unit.decompositionMethods;

//Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.

import static com.evgeny.unit.decompositionMethods.TaskTwoDecomposition.*;

public class TaskSixDecomposition {
    public static void main(String[] args) {
        int[] array = new int[3];
        randomValue(array); //используем статический метод для заполниния массива рандомными числами из класса TaskTwoDecomposition
        if (generalNod(array) == 1) {
            System.out.println("Числа взаимно простые.");
        } else {
            System.out.println("Числа не взаимно простые.");
        }
    }

    public static int generalNod(int[] array) {
        int b = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (b == 0) {
                b = nod(array[i], array[i + 1]); //статический метод nod используем из класса TaskTwoDecomposition
            } else {
                b = nod(b, array[i + 1]);
            }
        }
        return b;
    }
}