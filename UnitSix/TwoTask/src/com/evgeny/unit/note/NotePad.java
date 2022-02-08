package com.evgeny.unit.note;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class NotePad {
    private static final String DELIMITER = "****************";
    static String NAME_FILE = "notes.txt";
    private File file;
    private List<Note> noteList;
    private List<Note> selectNotes;

    public NotePad() {
        readFile();
    }

    private void readFile() {
        noteList = new ArrayList<>();
        file = new File(NAME_FILE);
        if (file.exists() && file.canRead()) {
            try (Scanner in = new Scanner(new FileReader(file))) {
                while (in.hasNextLine()) {
                    String topic = in.nextLine();
                    String date = in.nextLine();
                    String email = in.nextLine();
                    StringBuilder text = new StringBuilder("");
                    String nextLine;
                    while (in.hasNextLine() && !(nextLine = in.nextLine()).equals(DELIMITER)) {
                        text.append(nextLine);
                        text.append("\n");
                    }
                    String textList = text.toString();
                    while (textList.endsWith("\n")) {
                        textList = textList.substring(0, textList.length() - 1);
                    }
                    noteList.add(new Note(topic, date, email, textList));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveToFile() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (file.setWritable(true)) {
            try (PrintWriter out = new PrintWriter(file)) {
                for (Note note : noteList) {
                    out.println(note.getTopic());
                    out.println(note.getDate());
                    out.println(note.getEmail());
                    out.println(note.getText());
                    out.println(DELIMITER);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error save file");
        }
    }

    public int countOfNotes() {
        return noteList.size();
    }

    public int countOfSelected() {
        return selectNotes == null ? 0 : selectNotes.size();
    }

    public void addNote(Note note) {
        noteList.add(note);
    }

    public boolean printSelected() {
        if (selectNotes != null) {
            for (Note note : selectNotes) {
                System.out.println(note);
                System.out.println(DELIMITER);
            }
            return true;
        } else {
            return false;
        }
    }

    public void flush() {
        selectNotes = null;
    }

    public void printAll() {
        for (Note note : noteList) {
            System.out.println(note);
            System.out.println(DELIMITER);
        }
    }

    public boolean sortSelected(Comparator<Note> comparator) {
        if (selectNotes != null) {
            Collections.sort(selectNotes, comparator);
            return true;
        } else {
            return false;
        }
    }

    public void filter(NoteMatcher matcher) {
        if (selectNotes == null) {
            selectNotes = noteList;
        }
        ArrayList<Note> filteredNotes = new ArrayList<>();
        for (Note note : selectNotes) {
            if (matcher.match(note)) {
                filteredNotes.add(note);
            }
        }
        selectNotes = filteredNotes;
    }
}