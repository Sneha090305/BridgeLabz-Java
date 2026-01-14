package coreprogramming.controlflow.level1;

import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = input.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        System.out.println(
                "The sum of first " + n + " natural numbers is " + sum
        );

        input.close();
    }
}
