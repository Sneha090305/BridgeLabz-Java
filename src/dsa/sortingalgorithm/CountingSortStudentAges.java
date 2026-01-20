package dsa.sortingalgorithm;

import java.util.Scanner;

public class CountingSortStudentAges {

    static void countingSort(int[] arr) {

        int minAge = 10;
        int maxAge = 18;

        int[] count = new int[maxAge - minAge + 1];

        for (int age : arr) {
            count[age - minAge]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i + minAge;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];

        System.out.println("Enter student ages:");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }

        countingSort(ages);

        System.out.println("Sorted Ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        sc.close();
    }
}
