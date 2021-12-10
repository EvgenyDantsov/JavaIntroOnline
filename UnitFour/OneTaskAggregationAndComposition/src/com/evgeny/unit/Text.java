package com.evgeny.unit;

public class Text {
    private String header;
    private String text;

    public Text(Word word, Sentence sentence) {
        this.header = word.getWord();
        this.text = sentence.getSentence();
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public void addText(Word word) {
        text += " " + word.getWord();
    }

    public void addText(Sentence sentence) {
        text += " " + sentence.getSentence();
    }
}
