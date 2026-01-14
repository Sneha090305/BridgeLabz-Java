package coreprogramming.methods.level1;

import java.util.Scanner;

class SimpleInterest {

    static double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time: ");
        double time = sc.nextDouble();

        double si = calculateSimpleInterest(principal, rate, time);

        System.out.println("Simple Interest = " + si);

        sc.close();
    }
}
