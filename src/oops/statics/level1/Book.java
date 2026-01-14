package oops.statics.level1;

import java.util.Scanner;

public class Book {

    static String libraryName = "Central Library";

    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void display(Object obj) {
        if (obj instanceof Book) {
            System.out.println("Title  : " + title);
            System.out.println("Author : " + author);
            System.out.println("ISBN   : " + isbn);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b = new Book("Java", "James", "ISBN123");
        displayLibraryName();
        b.display(b);
        sc.close();
    }
}
