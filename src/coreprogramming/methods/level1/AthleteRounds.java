package coreprogramming.methods.level1;

import java.util.Scanner;

class AthleteRounds {
    static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();

        System.out.println("Rounds needed = " + calculateRounds(side1, side2, side3));
        sc.close();
    }
}
