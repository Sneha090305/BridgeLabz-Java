import java.util.Scanner;

public class LibraryManagement {

    static class Book {
        String title;
        int publicationYear;

        Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        void displayInfo() {
            System.out.println("Book Title: " + title);
            System.out.println("Publication Year: " + publicationYear);
        }
    }

    static class Author extends Book {
        String authorName;
        String bio;

        Author(String title, int year, String authorName, String bio) {
            super(title, year);
            this.authorName = authorName;
            this.bio = bio;
        }

        void displayInfo() {
            super.displayInfo();
            System.out.println("Author Name: " + authorName);
            System.out.println("Author Bio: " + bio);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter publication year: ");
        int year = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter author name: ");
        String authorName = sc.nextLine();

        System.out.print("Enter author bio: ");
        String bio = sc.nextLine();

        Author author = new Author(title, year, authorName, bio);

        System.out.println("\n--- Book Details ---");
        author.displayInfo();

        sc.close();
    }
}
