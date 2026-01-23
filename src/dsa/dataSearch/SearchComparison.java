package dsa.dataSearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchComparison {


    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] data = new int[size];


        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            data[i] = sc.nextInt();
        }


        System.out.print("Enter target element to search: ");
        int target = sc.nextInt();


        long start = System.nanoTime();
        int linearResult = linearSearch(data, target);
        long end = System.nanoTime();

        System.out.println("\nLinear Search Result:");
        System.out.println("Index = " + linearResult);
        System.out.println("Time (ns) = " + (end - start));


        Arrays.sort(data);

        start = System.nanoTime();
        int binaryResult = binarySearch(data, target);
        end = System.nanoTime();

        System.out.println("\nBinary Search Result:");
        System.out.println("Index = " + binaryResult);
        System.out.println("Time (ns) = " + (end - start));

        sc.close();
    }
}
