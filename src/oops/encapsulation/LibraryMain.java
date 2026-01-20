package oops.encapsulation;

import java.util.Scanner;

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {

    private int itemId;
    private String title;
    private String author;
    protected boolean available = true;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID   : " + itemId);
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Available : " + available);
        System.out.println("Loan Days : " + getLoanDuration());
    }
}

class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem() {
        available = false;
    }

    public boolean checkAvailability() {
        return available;
    }
}

public class LibraryMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.println("1. Book");
        System.out.println("2. Magazine");
        System.out.println("3. DVD");
        System.out.print("Choose Item Type: ");
        int choice = sc.nextInt();

        LibraryItem item;

        if (choice == 1) {
            item = new Book(id, title, author);
        } else if (choice == 2) {
            item = new Magazine(id, title, author);
        } else {
            item = new DVD(id, title, author);
        }

        Reservable r = (Reservable) item;

        System.out.println("\n---- Item Details ----");
        item.getItemDetails();

        System.out.print("\nReserve item? (1 = Yes, 0 = No): ");
        int reserve = sc.nextInt();

        if (reserve == 1 && r.checkAvailability()) {
            r.reserveItem();
            System.out.println("Item reserved successfully");
        } else {
            System.out.println("Item not reserved");
        }

        System.out.println("\n---- Updated Item Details ----");
        item.getItemDetails();

        sc.close();
    }
}
