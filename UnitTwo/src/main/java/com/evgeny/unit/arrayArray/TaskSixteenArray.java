package com.evgeny.unit.arrayArray;

//Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3,
//..., 2 n так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
//собой. Построить такой квадрат. Пример магического квадрата порядка 3:
//|6 1 8|
//|7 5 3|
//|2 9 4|

import java.util.Scanner;

public class TaskSixteenArray {
    public static void main(String[] args) {
        System.out.println("Пожалуйста, выберите порядок вывода магического квадрата:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[][] = new int[n][n];
        if (n%2!=0){  // Нечетный порядок
            oddMagic(n,array);
        }else if (n%4!=0){  // Одиночный и четный порядок
            return;
        }else{  // Двойной четный порядок
            doubleEvenMagic(n,array);
        }
    }

    public static void oddMagic(int n,int array[][]){
        int i = 0;
        int j = n/2;
        for (int k = 1; k <= n*n; k++) {
            array[i][j] = k;
            if (k%n==0) {  // Если текущее число кратно n, спускаемся вниз
                i++;
            }else{  // Если текущее число не кратно n, идем вверх влево
                i--;
                j++;
                if (i<0) i=n-1;
                if (j>n-1) j=0;
            }
        }
    }

    public static void doubleEvenMagic(int n,int array[][]){
        int c1=1,c2=n*n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i%4==j%4||(i+j)%4==3){  // Диагональ перевернута
                    array[i][j] = c2;
                }else{  // Недиагональный передний ряд
                    array[i][j] = c1;
                }
                c2--;
                c1++;
            }
        }
    }

    public static void printSquare(int array[][]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%4d",array[i][j]);
            }
            System.out.println();
        }
    }
    }
