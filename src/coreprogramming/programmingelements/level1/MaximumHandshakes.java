package coreprogramming.programmingelements.level1;

import java.util.Scanner;

public class MaximumHandshakes {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();

        int maximumHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        System.out.println(
                "The maximum number of handshakes among " +
                        numberOfStudents + " students is " + maximumHandshakes
        );

        input.close();
    }
}
