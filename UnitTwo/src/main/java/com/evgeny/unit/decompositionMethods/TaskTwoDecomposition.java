package com.evgeny.unit.decompositionMethods;

//Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.

public class TaskTwoDecomposition {
    public static void main(String[] args) {
        int[] array = new int[4];
        randomValue(array);
        System.out.print("Наибольший общий делитель четырех чисел: " + generalNodForAllDenominators(array));
    }

    public static void randomValue(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int generalNodForAllDenominators(int[] array) {
        int b = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (b == 0) {
                b = nod(array[i], array[i + 1]);
            } else {
                b = nod(b, array[i + 1]);
            }
        }
        return b;
    }

    public static int nod(int a, int b) {
        return b == 0 ? a : nod(b, a % b);
    }
}
