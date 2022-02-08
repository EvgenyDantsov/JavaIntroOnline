package com.evgeny.unit.menu;

import com.evgeny.unit.note.Note;
import com.evgeny.unit.note.NoteMatcher;
import com.evgeny.unit.note.Notes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void notePadMenu() {
        Notes notePad = new Notes();
        boolean isExit = true;
        while (isExit) {
            System.out.print("Total notes: " + notePad.countOfNotes() +
                    "\n0. Exit" +
                    "\n1. Add new note" +
                    "\n2. Filter" +
                    "\n3. Print all" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                isExit = false;
                break;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    Note note = getNote();
                    notePad.addNote(note);
                    notePad.saveToFile();
                    break;
                case 2:
                    boolean isFilter = true;
                    while (isFilter) {
                        System.out.print("Selected: " + notePad.countOfSelected() +
                                "\n0. Exit" +
                                "\n1. New filter" +
                                "\n2. Sort filtered" +
                                "\n3. Print filtered" +
                                "\n4. Clean filter" +
                                "\nSelect: ");
                        int choice2 = readInt();
                        if (choice2 == 0) {
                            isFilter = false;
                            break;
                        }
                        if (choice2 < 1 || choice2 > 4) {
                            System.out.println("Incorrect menu item selected, reenter.");
                            continue;
                        }
                        switch (choice2) {
                            case 1:
                                filter(notePad);
                                break;
                            case 2:
                                sort(notePad);
                                break;
                            case 3:
                                if(!notePad.printSelected()){
                                    System.out.println("No specified filter parameters.");
                                }
                                notePad.flush();
                                break;
                            case 4:
                                notePad.flush();
                                break;
                        }
                    }
                    break;
                case 3:
                    notePad.printAll();
                    break;
            }
        }
    }

    private static Note getNote() {
        Note note = new Note();
        System.out.print("Enter topic: ");
        String topic = readString();
        note.setTopic(topic);
        System.out.print("Enter date \"yyyy-mm-dd\": ");
        String date = readString();
        while (!note.setDate(date)) {
            System.out.println("Invalid input date. Please, try again");
            date = readString();
        }
        System.out.print("Enter email: ");
        String email = readString();
        while (!note.setEmail(email)) {
            System.out.println("Invalid input email. Please, try again");
            email = readString();
        }
        System.out.println("Enter note text. Enter Q to finish");
        StringBuilder text = new StringBuilder("");
        String newLine = "";
        while (!(newLine = readString()).equals("Q")) {
            text.append(newLine);
            text.append("\n");
        }
        String textStr = text.toString();
        while (textStr.endsWith("\n")) {
            textStr = textStr.substring(0, textStr.length() - 1);
        }
        note.setText(textStr);
        return note;
    }

    private static void filter(Notes notebook) {
        NoteMatcher matcher = new NoteMatcher();
        System.out.println("Enter topic or empty to skip:");
        String topic = readString();
        matcher.setTopic(topic);
        System.out.println("Enter the words that should be in the text or empty to skip:");
        String words = readString();
        matcher.setWords(words);
        notebook.filter(matcher);
    }

    private static void sort(Notes notebook) {
        boolean isSort = true;
        while (isSort) {
            System.out.print("Enter sort parameter:" +
                    "\n0. Exit" +
                    "\n1. Topic" +
                    "\n2. Date" +
                    "\nSelect: ");
            int choice = readInt();
            if (choice == 0) {
                isSort = false;
                break;
            }
            if (choice < 1 || choice > 2) {
                System.out.println("Incorrect menu item selected, reenter.");
                continue;
            }
            switch (choice) {
                case 1:
                    if(!notebook.sortSelected(Note.topicComparator)) {
                        System.out.println("No specified filter parameters.");
                    }
                    isSort = false;
                    break;
                case 2:
                    if(!notebook.sortSelected(Note.dateComparator)) {
                        System.out.println("No specified filter parameters.");
                    }
                    isSort = false;
                    break;
            }
        }
    }

    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("An error occurred while trying to enter a number. Try again.");
            return readInt();
        }
    }

    public static String readString() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("An error occurred while trying to enter text. Try again.");
            return readString();
        }
    }
}