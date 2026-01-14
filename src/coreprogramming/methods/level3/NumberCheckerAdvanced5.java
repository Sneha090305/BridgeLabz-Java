package coreprogramming.methods.level3;

import java.util.Scanner;

public class NumberCheckerAdvanced5 {

    public static int[] factors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }

        int[] arr = new int[count];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) arr[index++] = i;
        }
        return arr;
    }

    public static int sumProperDivisors(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum;
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) f *= i;
        return f;
    }

    public static boolean isStrong(int n) {
        int temp = n;
        int sum = 0;
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int sum = sumProperDivisors(n);

        System.out.println("Perfect number: " + (sum == n));
        System.out.println("Abundant number: " + (sum > n));
        System.out.println("Deficient number: " + (sum < n));
        System.out.println("Strong number: " + isStrong(n));

        sc.close();
    }
}