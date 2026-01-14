package coreprogramming.controlflow.level1;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int reverse = 0;

        while (number != 0) {
            int digit = number % 10;      // get last digit
            reverse = reverse * 10 + digit;
            number = number / 10;         // remove last digit
        }

        System.out.println("The reversed number is " + reverse);

        input.close();
    }
}
