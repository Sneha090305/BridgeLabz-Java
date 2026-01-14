package coreprogramming.controlflow.level1;

import java.util.Scanner;

public class SumCompareWhile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n > 0) {

            int sumWhile = 0;
            int i = 1;

            // sum using while loop
            while (i <= n) {
                sumWhile += i;
                i++;
            }

            // sum using formula
            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumWhile == sumFormula) {
                System.out.println("Both results are correct and equal.");
            } else {
                System.out.println("Results are not equal.");
            }

        } else {
            System.out.println("Not a natural number.");
        }

        sc.close();
    }
}
