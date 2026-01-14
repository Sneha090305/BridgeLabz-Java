package coreprogramming.methods.level3;

import java.util.Scanner;

public class NumberCheckerAdvanced {

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

    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    public static void findLargestSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second Largest digit: " + secondLargest);
    }

    public static void findSmallestSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }

        System.out.println("Smallest digit: " + smallest);
        System.out.println("Second Smallest digit: " + secondSmallest);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Duck number: " + isDuckNumber(digits));
        System.out.println("Armstrong number: " + isArmstrong(number, digits));

        findLargestSecondLargest(digits);
        findSmallestSecondSmallest(digits);

        sc.close();
    }
}
