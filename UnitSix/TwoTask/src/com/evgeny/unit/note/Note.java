package com.evgeny.unit.note;

import com.evgeny.unit.date.Date;
import com.evgeny.unit.email.Email;

import java.io.Serializable;
import java.util.Comparator;

public class Note implements Serializable {
    static final long serialVersionUID = -7588980448999010399L;
    private String topic;
    private Date date;
    private Email email;
    private String text;

    public Note() {
        date = new Date();
        email = new Email("");
    }

    public Note(String topic, String date, String email, String text) {
        this.topic = topic;
        this.date = new Date(date);
        this.email = new Email(email);
        this.text = text;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public boolean setDate(String date) {
        try {
            this.date.setLocalDate(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Email getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        return this.email.setEmail(email);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Comparator<Note> dateComparator = (note1, note2) -> note1.getDate().compareTo(note2.getDate());

    public static Comparator<Note> topicComparator = Comparator.comparing(Note::getTopic);

    @Override
    public String toString() {
        return "Topic: '" + topic + '\'' +
                " \nDate: " + date +
                " \nEmail: " + email +
                " \nText: '" + text + '\'';
    }
}