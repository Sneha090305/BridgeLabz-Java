package coreprogramming.string.extra2;

import java.util.Scanner;

public class TemperatureConverter {

    static double toCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double toFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double temp = sc.nextDouble();
        int choice = sc.nextInt();

        if (choice == 1)
            System.out.println("Celsius = " + toCelsius(temp));
        else
            System.out.println("Fahrenheit = " + toFahrenheit(temp));
    }
}

