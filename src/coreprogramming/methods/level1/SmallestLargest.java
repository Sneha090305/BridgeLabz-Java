package coreprogramming.methods.level1;

import java.util.Scanner;

class SmallestLargest {

    static int[] findSmallestLargest(int a, int b, int c) {

        int smallest = a;
        int largest = a;

        if (b < smallest) smallest = b;
        if (c < smallest) smallest = c;

        if (b > largest) largest = b;
        if (c > largest) largest = c;

        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] result = findSmallestLargest(a, b, c);

        System.out.println("Smallest = " + result[0]);
        System.out.println("Largest = " + result[1]);

        sc.close();
    }
}
