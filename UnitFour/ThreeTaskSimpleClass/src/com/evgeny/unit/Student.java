package com.evgeny.unit;

public class Student {
    private String surname;
    private String initials;
    private int numberGroup;
    private int[] progressGrades;
    private int countGrades;

    public Student(String surname, String initials, int numberGroup) {
        this.surname = surname;
        this.initials = initials;
        this.numberGroup = numberGroup;
        countGrades = 0;
        this.progressGrades = new int[5];
    }

    boolean addGrade(int grade) {
        if (countGrades >= 5) {
            return false;
        }
        progressGrades[countGrades] = grade;
        countGrades++;
        return true;
    }

    boolean isGoodGrade() {
        for (int i = 0; i < countGrades; ++i)
            if (progressGrades[i] != 9 && progressGrades[i] != 10)
                return false;
        return true;
    }

    void printStudent() {
        System.out.print(surname + " " + initials);
        System.out.print(" Group: " + numberGroup + ". ProgressGrades: ");
        for (int i = 0; i < countGrades; ++i)
            System.out.print(progressGrades[i] + " ");
        System.out.print("\n");
    }
}
