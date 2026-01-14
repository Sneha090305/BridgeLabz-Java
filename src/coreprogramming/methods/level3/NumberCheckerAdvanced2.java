package coreprogramming.methods.level3;

import java.util.Scanner;

public class NumberCheckerAdvanced2 {

    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int size = countDigits(number);
        int[] digits = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number = number / 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    public static boolean isHarshad(int number, int sumDigits) {
        return number % sumDigits == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
        }

        for (int d : digits) {
            freq[d][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        int sumDigits = sumOfDigits(digits);
        int sumSquares = sumOfSquares(digits);

        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Sum of digits: " + sumDigits);
        System.out.println("Sum of squares of digits: " + sumSquares);
        System.out.println("Harshad number: " + isHarshad(number, sumDigits));

        int[][] freq = digitFrequency(digits);

        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0) {
                System.out.println(freq[i][0] + " -> " + freq[i][1]);
            }
        }

        sc.close();
    }
}
