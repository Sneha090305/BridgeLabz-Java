package dsa.sortingalgorithm;

import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] empIds = new int[n];

        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = sc.nextInt();
        }

        insertionSort(empIds);

        System.out.println("Sorted Employee IDs:");
        for (int id : empIds) {
            System.out.print(id + " ");
        }

        sc.close();
    }
}
