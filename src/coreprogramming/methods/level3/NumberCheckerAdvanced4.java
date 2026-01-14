package coreprogramming.methods.level3;

import java.util.Scanner;

public class NumberCheckerAdvanced4 {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int n) {
        int sq = n * n;
        int sum = 0;
        while (sq > 0) {
            sum += sq % 10;
            sq /= 10;
        }
        return sum == n;
    }

    public static boolean isSpy(int n) {
        int sum = 0, prod = 1;
        while (n > 0) {
            int d = n % 10;
            sum += d;
            prod *= d;
            n /= 10;
        }
        return sum == prod;
    }

    public static boolean isAutomorphic(int n) {
        int sq = n * n;
        return String.valueOf(sq).endsWith(String.valueOf(n));
    }

    public static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Prime number: " + isPrime(n));
        System.out.println("Neon number: " + isNeon(n));
        System.out.println("Spy number: " + isSpy(n));
        System.out.println("Automorphic number: " + isAutomorphic(n));
        System.out.println("Buzz number: " + isBuzz(n));

        sc.close();
    }
}