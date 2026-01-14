package coreprogramming.methods.level1;

import java.util.Scanner;

class QuotientRemainder {

    static int[] findQuotientRemainder(int number, int divisor) {
        return new int[]{number / divisor, number % divisor};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        int[] result = findQuotientRemainder(number, divisor);

        System.out.println("Quotient = " + result[0]);
        System.out.println("Remainder = " + result[1]);

        sc.close();
    }
}
