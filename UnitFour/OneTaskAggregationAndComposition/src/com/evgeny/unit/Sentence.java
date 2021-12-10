package com.evgeny.unit;

public class Sentence {
    private String sentence = "";

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public Sentence() {

    }

    public void addSentence(Word word) {
        sentence += " " + word.getWord();
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence += sentence;
    }
}
