package com.evgeny.unit;

import java.util.Scanner;

public class Text {
    private String header;
    private String text;

    public Text() {
        this.header = "----";
        this.text = "----";
    }

    public void menu(){
        int value;
        Word word = new Word();
        Sentence sentence = new Sentence();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите заголовок: ");
        word.setWord(in.nextLine());
        setHeader(word.getWord());
        System.out.print("Введите педложение: ");
        sentence.setSentence(in.nextLine());
        while (true) {
            System.out.print("Вы хотите дополнить текст:\n" +
                    "1. Да\n" +
                    "2. Нет\n");
            value = in.nextInt();
            switch (value) {
                case 1:
                    System.out.print("Введите предложение: ");
                    in.nextLine();
                    sentence.addSentence(in.nextLine());
                    break;
                case 2:
                    addText(sentence);
                    System.out.println("Заголовок: " + getHeader());
                    System.out.println("Текст: " + getText());
                    break;
            }
            if(value == 2){break;}
        }
    }
    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addText(Sentence sentence) {
        text = sentence.getSentence();
    }
}
