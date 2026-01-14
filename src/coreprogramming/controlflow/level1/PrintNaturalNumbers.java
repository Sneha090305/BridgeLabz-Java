package coreprogramming.controlflow.level1;

import java.util.Scanner;

public class PrintNaturalNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }

        input.close();
    }
}
