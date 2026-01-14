package coreprogramming.string.extra2;

import java.util.Scanner;

public class BasicCalculator {

    static double calculate(double a, double b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        char op = sc.next().charAt(0);

        System.out.println("Result = " + calculate(a, b, op));
    }
}

