package coreprogramming.controlflow.level3;

import java.util.Scanner;

public class CalculatorSwitch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double first = sc.nextDouble();

        System.out.print("Enter second number: ");
        double second = sc.nextDouble();

        System.out.print("Enter operator (+ - * /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println(first + second);
                break;
            case '-':
                System.out.println(first - second);
                break;
            case '*':
                System.out.println(first * second);
                break;
            case '/':
                System.out.println(first / second);
                break;
            default:
                System.out.println("Invalid Operator");
        }

        sc.close();
    }
}
