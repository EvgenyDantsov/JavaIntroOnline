package com.evgeny.unit;

//Создать объект класса Текст, используя классы Предложение, Слово.
// Методы: дополнить текст, вывести на консоль текст, заголовок текста.

public class Main {

    public static void main(String[] args) {
        Word word = new Word("Заголовок");
        Sentence sentence = new Sentence("xnjnj");
        Text text = new Text(word, sentence);

        Word word1 = new Word("Предложение");
        Word word2 = new Word("новое");
        Word word3 = new Word("создается.");

        sentence.addSentence(word1);
        sentence.addSentence(word2);
        sentence.addSentence(word3);
        sentence.setSentence("Вы добавляете новое предложение.");
        text.addText(sentence);
        text.addText(word);

        System.out.println("Head: "+text.getHeader());
        System.out.println("Body: "+text.getText());
    }
}
