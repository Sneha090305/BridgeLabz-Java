package dsa.linkedlist;

import java.util.Scanner;

class BookNode {
    int bookId;
    String title;
    String author;
    String genre;
    boolean available;
    BookNode next;
    BookNode prev;

    BookNode(int bookId, String title, String author, String genre, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagement {

    private BookNode head;
    private BookNode tail;

    public void addAtBeginning(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtEnd(int id, String title, String author, String genre, boolean available) {
        BookNode newNode = new BookNode(id, title, author, genre, available);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtPosition(int pos, int id, String title, String author, String genre, boolean available) {
        if (pos == 1) {
            addAtBeginning(id, title, author, genre, available);
            return;
        }
        BookNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(id, title, author, genre, available);
            return;
        }
        BookNode newNode = new BookNode(id, title, author, genre, available);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void removeByBookId(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found");
    }

    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found");
    }

    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status;
                System.out.println("Availability updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No books available");
            return;
        }
        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books available");
            return;
        }
        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    private void displayBook(BookNode b) {
        System.out.println("Book ID    : " + b.bookId);
        System.out.println("Title      : " + b.title);
        System.out.println("Author     : " + b.author);
        System.out.println("Genre      : " + b.genre);
        System.out.println("Available  : " + b.available);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryManagement library = new LibraryManagement();

        while (true) {
            System.out.println("\n1 Add at Beginning");
            System.out.println("2 Add at End");
            System.out.println("3 Add at Position");
            System.out.println("4 Remove by Book ID");
            System.out.println("5 Search by Title");
            System.out.println("6 Search by Author");
            System.out.println("7 Update Availability");
            System.out.println("8 Display Forward");
            System.out.println("9 Display Reverse");
            System.out.println("10 Count Books");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0)
                break;

            int id, pos;
            String title, author, genre;
            boolean available;

            switch (choice) {
                case 1:
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author: ");
                    author = sc.nextLine();
                    System.out.print("Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    available = sc.nextBoolean();
                    library.addAtBeginning(id, title, author, genre, available);
                    break;

                case 2:
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author: ");
                    author = sc.nextLine();
                    System.out.print("Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    available = sc.nextBoolean();
                    library.addAtEnd(id, title, author, genre, available);
                    break;

                case 3:
                    System.out.print("Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Author: ");
                    author = sc.nextLine();
                    System.out.print("Genre: ");
                    genre = sc.nextLine();
                    System.out.print("Available (true/false): ");
                    available = sc.nextBoolean();
                    library.addAtPosition(pos, id, title, author, genre, available);
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    library.removeByBookId(id);
                    break;

                case 5:
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    library.searchByTitle(title);
                    break;

                case 6:
                    System.out.print("Author: ");
                    author = sc.nextLine();
                    library.searchByAuthor(author);
                    break;

                case 7:
                    System.out.print("Book ID: ");
                    id = sc.nextInt();
                    System.out.print("Available (true/false): ");
                    available = sc.nextBoolean();
                    library.updateAvailability(id, available);
                    break;

                case 8:
                    library.displayForward();
                    break;

                case 9:
                    library.displayReverse();
                    break;

                case 10:
                    library.countBooks();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}

