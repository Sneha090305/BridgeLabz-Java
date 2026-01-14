package coreprogramming.controlflow.level2;

import java.util.Scanner;

public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            int counter = number - 1;
            while (counter > 1) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        } else {
            System.out.println("Invalid input");
        }

        sc.close();
    }
}
