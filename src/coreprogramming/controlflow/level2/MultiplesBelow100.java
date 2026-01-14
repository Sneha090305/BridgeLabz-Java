package coreprogramming.controlflow.level2;

import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number (<100): ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.println(i);
                    continue;
                }
            }
        } else {
            System.out.println("Invalid input");
        }

        sc.close();
    }
}
