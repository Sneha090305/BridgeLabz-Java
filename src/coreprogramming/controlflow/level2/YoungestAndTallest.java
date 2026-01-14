package coreprogramming.controlflow.level2;

import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter height of Amar: ");
        int heightAmar = sc.nextInt();

        System.out.print("Enter age of Akbar: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter height of Akbar: ");
        int heightAkbar = sc.nextInt();

        System.out.print("Enter age of Anthony: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter height of Anthony: ");
        int heightAnthony = sc.nextInt();

        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));

        System.out.println("Youngest age is: " + youngestAge);
        System.out.println("Tallest height is: " + tallestHeight);

        sc.close();
    }
}

