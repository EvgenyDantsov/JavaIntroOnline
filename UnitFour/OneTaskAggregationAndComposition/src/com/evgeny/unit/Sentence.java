package com.evgeny.unit;

public class Sentence {
    private String sentence;

    public Sentence() {
        this.sentence = "Отсутствует.";
    }

    public void addSentence(String sentence) {
        this.sentence += " " + sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
