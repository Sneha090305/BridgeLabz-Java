package coreprogramming.methods.level3;

import java.util.Scanner;

public class NumberCheckerAdvanced3 {

    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int size = countDigits(number);
        int[] digits = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] rev = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            rev[i] = digits[digits.length - 1 - i];
        }
        return rev;
    }

    public static boolean areArraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);
        int[] reversed = reverseDigits(digits);

        System.out.println("Palindrome number: " + areArraysEqual(digits, reversed));
        System.out.println("Duck number: " + isDuckNumber(digits));

        sc.close();
    }
}