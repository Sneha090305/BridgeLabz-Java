package coreprogramming.string.level3;

import java.util.Scanner;

public class BMICalculator {

    public static String getStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        if (bmi <= 24.9) return "Normal";
        if (bmi <= 39.9) return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        System.out.println("Weight Height BMI Status");

        for (int i = 0; i < 10; i++) {
            double heightM = data[i][1] / 100;
            double bmi = data[i][0] / (heightM * heightM);
            System.out.println(data[i][0] + " " + data[i][1] + " " + bmi + " " + getStatus(bmi));
        }

        sc.close();
    }
}
