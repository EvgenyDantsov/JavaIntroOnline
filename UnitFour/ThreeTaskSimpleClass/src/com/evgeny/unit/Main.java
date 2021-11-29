package com.evgeny.unit;

//Создайте класс с именем Student, содержащий поля: фамилия и инициалы,
// номер группы, успеваемость (массив из пяти элементов).
// Создайте массив из десяти элементов такого типа. Добавьте возможность вывода
// фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 10;
        Student students[] = new Student[n];
        students[0] = new Student("Петрик", "А.И.", 1);
        students[1] = new Student("Пупкин", "В.И.", 1);
        students[2] = new Student("Рыбкин", "А.С.", 1);
        students[3] = new Student("Акулич", "А.С.", 2);
        students[4] = new Student("Змейкин", "Ф.М.", 2);
        students[5] = new Student("Продовков", "И.И.", 3);
        students[6] = new Student("Арибертов", "И.К.", 3);
        students[7] = new Student("Матрен", "В.В.", 3);
        students[8] = new Student("Искан", "М.Т.", 3);
        students[9] = new Student("Сол", "Ф.Г.", 3);
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            students[i].addGrade(rnd.nextInt(6) + 5);
            students[i].addGrade(rnd.nextInt(6) + 5);
        }
        System.out.println("Все студенты: ");
        for (int i = 0; i < n; ++i) {
            students[i].printStudent();
        }
        System.out.println("\nХорошие студенты: ");
        for (int i = 0; i < n; ++i) {
            if (students[i].isGoodGrade()) {
                students[i].printStudent();
            }
        }
    }
}
