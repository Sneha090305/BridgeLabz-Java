package dsa.linkedlist;

import java.util.Scanner;

class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagement {

    private MovieNode head;
    private MovieNode tail;

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void removeByTitle(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found");
    }

    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating >= rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found");
    }

    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    public void displayForward() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies available");
            return;
        }
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies available");
            return;
        }
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    private void displayMovie(MovieNode m) {
        System.out.println("Title    : " + m.title);
        System.out.println("Director : " + m.director);
        System.out.println("Year     : " + m.year);
        System.out.println("Rating   : " + m.rating);
        System.out.println("---------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieManagement list = new MovieManagement();

        while (true) {
            System.out.println("\n1 Add at Beginning");
            System.out.println("2 Add at End");
            System.out.println("3 Add at Position");
            System.out.println("4 Remove by Title");
            System.out.println("5 Search by Director");
            System.out.println("6 Search by Rating");
            System.out.println("7 Update Rating");
            System.out.println("8 Display Forward");
            System.out.println("9 Display Reverse");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) break;

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.addAtBeginning(title, director, year, rating);
                    break;

                case 2:
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.addAtEnd(title, director, year, rating);
                    break;

                case 3:
                    System.out.print("Position: ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    System.out.print("Rating: ");
                    rating = sc.nextDouble();
                    list.addAtPosition(pos, title, director, year, rating);
                    break;

                case 4:
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    list.removeByTitle(title);
                    break;

                case 5:
                    System.out.print("Director: ");
                    director = sc.nextLine();
                    list.searchByDirector(director);
                    break;

                case 6:
                    System.out.print("Minimum Rating: ");
                    rating = sc.nextDouble();
                    list.searchByRating(rating);
                    break;

                case 7:
                    System.out.print("Title: ");
                    title = sc.nextLine();
                    System.out.print("New Rating: ");
                    rating = sc.nextDouble();
                    list.updateRating(title, rating);
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
