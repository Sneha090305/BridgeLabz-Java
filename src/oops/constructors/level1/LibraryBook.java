package oops.constructors.level1;

import java.util.Scanner;

public class LibraryBook {

    private String title;
    private String author;
    private double price;
    private boolean available;

    // Parameterized constructor
    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book is not available");
        }
    }

    public void display() {
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Price       : " + price);
        System.out.println("Available   : " + available);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        LibraryBook book = new LibraryBook(title, author, price);
        book.display();

        book.borrowBook();
        book.display();

        sc.close();
    }
}
