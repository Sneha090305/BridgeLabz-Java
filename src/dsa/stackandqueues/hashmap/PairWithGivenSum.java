import java.util.HashSet;
import java.util.Scanner;

class PairWithGivenSum {

    static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at index " + i + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if (hasPair(arr, target)) {
            System.out.println("Pair with given sum exists");
        } else {
            System.out.println("Pair with given sum does NOT exist");
        }

        sc.close();
    }
}
