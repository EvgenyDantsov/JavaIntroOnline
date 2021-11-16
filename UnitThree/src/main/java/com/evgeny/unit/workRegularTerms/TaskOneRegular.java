package com.evgeny.unit.workRegularTerms;

//Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять
// с текстом три различных операции: отсортировать абзацы по количеству предложений;
// в каждом предложении отсортировать слова по длине; отсортировать лексемы в предложении по убыванию
// количества вхождений заданного символа, а в случае равенства – по алфавиту.

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskOneRegular {
    public static void main(String[] args) {
        int value = 0, count = 0;
        char setChar = ' ';
        String string = "Привет яга ты. Привет мой юный друг. Клара ушла домой." +
                "\n Анастасия анна аннастисий ян. Осталось мало дней." +
                "\n Приезжай ко мне в гости.";
        String[] sentence = string.split("\\.");
        textProvisionAndOperations(string, sentence, value, count, setChar);
    }

    public static void textProvisionAndOperations(String string, String[] sentence, int value, int count, char setChar) {
        System.out.println("Выбирите операцию проводимую с текстом:" +
                "\n1. Отсортировать абзацы по количеству предложений." +
                "\n2. В каждом предложении отсортировать слова по длине." +
                "\n3. Отсортировать лексемы в предложении по убыванию количества вхождений заданного символа," +
                "\nа в случае равенства - по алфавиту.");
        Scanner in = new Scanner(System.in);
        System.out.print("Ваш выбор: ");
        value = in.nextInt();
        System.out.println("Исходный текст: \n" + string + "\n");
        switch (value) {
            case 1:
                sortParagraphCountSentence(string, count);
                break;
            case 2:
                sortWordLongwiseSentence(sentence, count);
                break;
            case 3:
                System.out.print("Введите символ по которому искать лексемы: ");
                setChar = in.next().charAt(0);
                sortLexemeSentenceDecending(sentence, setChar, count);
                break;
            default:
                System.out.println("Введено некоректное значение!");
                break;
        }
    }

    public static void sortParagraphCountSentence(String string, int count) {
        String[] paragraph = string.split("\n"); // разделяет по абзацам
        int[] countSentence = new int[paragraph.length];
        String tempParagraph = "";
        int tempCountSentence = 0;
        System.out.println("После выполнения операции с текстом:");
        Pattern pattern = Pattern.compile("\\?|\\.|!");//шаблон поиска (символ ? или . или !)
        for (int i = 0; i < paragraph.length; i++) {
            Matcher matcher = pattern.matcher(paragraph[i]);//проводиться поиск в тексте по шаблону
            while (matcher.find()) {    //считаем количество предложений в абзаце
                count++;
            }
            countSentence[i] = count;
            count = 0;
        }
        for (int i = 0; i < paragraph.length - 1; i++) {//сортируем по количеству предложений в абзаце
            for (int j = i + 1; j < paragraph.length; j++) {
                if (countSentence[i] > countSentence[j]) {
                    tempParagraph = paragraph[j];
                    tempCountSentence = countSentence[j];
                    paragraph[j] = paragraph[i];
                    countSentence[j] = countSentence[i];
                    paragraph[i] = tempParagraph;
                    countSentence[i] = tempCountSentence;
                }
            }
        }
        for (String p : paragraph) {
            System.out.println(p);
        }
    }

    public static void sortWordLongwiseSentence(String[] sentence, int count) {
        String temp = "";
        System.out.println("После выполнения операции с текстом:");
        for (int k = 0; k < sentence.length; k++) {
            String[] words = sentence[k].split(" "); //разделяем на слова
            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].length() < words[i].length()) { //проверяем если длина слова меньше, то меняем местами
                        temp = words[j];
                        words[j] = words[i];
                        words[i] = temp;
                    }
                }
            }
            printWords(words, count);
        }
    }

    public static void printWords(String[] words, int count) {
        for (String str : words) {
            if (words.length - 1 > count) {
                System.out.print(str + " ");
            } else System.out.print(str);
            count++;
        }
        System.out.print(". ");
    }

    public static void sortLexemeSentenceDecending(String[] sentence, char setChar, int count) {
        System.out.println("\nПосле выполнения операции с текстом:");
        for (int k = 0; k < sentence.length; k++) {
            String[] words = sentence[k].split(" "); //разбиваем на слова
            int[] countChar = new int[words.length];
            for (int i = 0; i < words.length; i++) { //считаем количество введенного символа в слове
                for (int j = 0; j < words[i].length(); j++) {
                    if (setChar == words[i].toLowerCase().charAt(j)) {
                        count++;
                    }
                }
                countChar[i] = count;
                count = 0;
                if (words.length - 1 == i) {
                    sortLexeme(countChar, words);
                }
            }
        }
    }

    public static void sortLexeme(int[] countChar, String[] words) {
        String temp = "";
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].compareTo("\n") == 0) { //если есть символ абзаца пропускаем шаг
                i++;
            }
            for (int j = i; j < words.length; j++) {
                if (countChar[i] == countChar[j]) { //если количество символов одинаково сортируем по алфовиту
                    if (words[i].compareToIgnoreCase(words[j]) > 0) { //не учитываем регистр символов
                        temp = words[j];
                        words[j] = words[i];
                        words[i] = temp;
                    }
                }
                if (countChar[i] < countChar[j]) {
                    temp = words[j];
                    count = countChar[j];
                    words[j] = words[i];
                    countChar[j] = countChar[i];
                    words[i] = temp;
                    countChar[i] = count;
                }
            }
        }
        count = 0;
        printWords(words, count);
    }
}
