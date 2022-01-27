package com.evgeny.unit.book;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Books {
    private static int bookIdCounter = 0;
    private List<Book> books;
    private File saveFile = new File("books.txt");

    public Books() {
        createBooks();
    }

    private void createBooks() {
        books = new ArrayList<>();
        if (saveFile.exists() && saveFile.canRead() && saveFile.length() != 0) {
            try (Scanner in = new Scanner(new FileReader(saveFile))) {
                while (in.hasNextLine()) {
                    String bookType = in.nextLine();
                    String title = in.nextLine();
                    String author = in.nextLine();
                    String publisher = in.nextLine();
                    int year = in.nextInt();
                    in.nextLine();
                    if (bookType.equalsIgnoreCase("e")) {
                        String location = in.nextLine();
                        Ebook ebook = new Ebook(0, title, new Author(author), new Publisher(publisher), year, location);
                        addBook(ebook);
                    } else {
                        Book book = new Book(0, title, new Author(author), new Publisher(publisher), year);
                        addBook(book);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveToFile() {
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (saveFile.setWritable(true)) {
            try (PrintWriter out = new PrintWriter(saveFile)) {
                for (Book book : books) {
                    out.println(book instanceof Ebook ? "e" : "p");
                    out.println(book.getTitle());
                    out.println(book.getAuthor());
                    out.println(book.getPublisher());
                    out.println(book.getYearOfPublishing());
                    if (book instanceof Ebook) {
                        out.println(((Ebook) book).getLocation());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: Unable to save file");
        }
    }

    public void addBook(Book book) {
        book.setId(bookIdCounter++);
        books.add(book);
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> filterByTitle(String title) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                filteredBooks.add(book);
            }
        }
        return (filteredBooks.size() > 0 ? filteredBooks : null);
    }

    public List<Book> filterByAuthor(String author) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                filteredBooks.add(book);
            }
        }
        return (filteredBooks.size() > 0 ? filteredBooks : null);
    }

    public List<Book> filterByPublisher(String publisher) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                filteredBooks.add(book);
            }
        }
        return (filteredBooks.size() > 0 ? filteredBooks : null);
    }

    public List<Book> filterByYear(int filterStart, int filterFinish) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (filterStart <= book.getYearOfPublishing() && book.getYearOfPublishing() <= filterFinish) {
                filteredBooks.add(book);
            }
        }
        return (filteredBooks.size() > 0 ? filteredBooks : null);
    }

    public List<Book> listAllBook() {
        return new ArrayList<>(books);
    }

    public boolean removeBook(int id) {
        return books.remove(findBookById(id));
    }
}
