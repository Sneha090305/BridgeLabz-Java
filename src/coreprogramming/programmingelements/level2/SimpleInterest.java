package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class SimpleInterest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter rate of interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter time (in years): ");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.println(
                "The Simple Interest is " + simpleInterest +
                        " for Principal " + principal +
                        ", Rate of Interest " + rate +
                        " and Time " + time
        );

        input.close();
    }
}
