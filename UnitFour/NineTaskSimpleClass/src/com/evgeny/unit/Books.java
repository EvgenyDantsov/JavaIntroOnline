package com.evgeny.unit;

public class Books {
    //private LinkedList<Book> listBook;
    private Book[] book = new Book[10];
    private int count = 0;

//    public Books(LinkedList<Book> listBook) {
//        this.listBook = listBook;
//    }
    public Books(Book[] book) {
        this.book = book;
        this.count = sizeBook();
    }
public int sizeBook(){
    setCount(0);
    for (int i = 0; i < book.length; i++){
        if(book[i] != null){
            count++;
        }
    }
    return count;
}
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void print(){
        for(int i = 0; i < book.length; i++){
            if(book[i] != null) {
                System.out.print(book[i]);
                System.out.println();
            }
        }
    }
    public void printAuthor(String nameAuthor) {
        for(int i = 0; i < book.length-1; i++){
            if (book[i] != null && book[i].getAuthor().compareTo(nameAuthor) == 0) {
                System.out.print(book[i]);
                System.out.println();
            }
        }
//        listBook.stream()
//                .filter(book -> book.getAuthor().compareTo(nameAuthor) == 0)
//                .forEach(System.out::println);
    }

//    public void printPublishingHouse(String namePublishingHouse) {
//        listBook.stream()
//                .filter(book -> book.getPublishingHouse().compareTo(namePublishingHouse) == 0)
//                .forEach(System.out::println);
//    }
//
//    public void printYearOfPublication(int yearOfPublication) {
//        listBook.stream()
//                .filter(book -> book.getYearOfPublication() > yearOfPublication)
//                .forEach(System.out::println);
//    }
}
