package dsa.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] data = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        int[] bubbleArr = data.clone();
        long start = System.nanoTime();
        bubbleSort(bubbleArr);
        long end = System.nanoTime();
        System.out.println("\nBubble Sort Result: " + Arrays.toString(bubbleArr));
        System.out.println("Bubble Sort Time (ns): " + (end - start));

        int[] mergeArr = data.clone();
        start = System.nanoTime();
        mergeSort(mergeArr);
        end = System.nanoTime();
        System.out.println("\nMerge Sort Result: " + Arrays.toString(mergeArr));
        System.out.println("Merge Sort Time (ns): " + (end - start));

        int[] quickArr = data.clone();
        start = System.nanoTime();
        Arrays.sort(quickArr);
        end = System.nanoTime();
        System.out.println("\nQuick Sort Result: " + Arrays.toString(quickArr));
        System.out.println("Quick Sort Time (ns): " + (end - start));

        sc.close();
    }
}
