import java.util.HashMap;
import java.util.Scanner;

class ZeroSumSubarray {

    static boolean hasZeroSumSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        map.put(0, 1);

        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum)) {
                return true;
            }
            map.put(sum, 1);
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

        if (hasZeroSumSubarray(arr)) {
            System.out.println("Zero-sum subarray exists");
        } else {
            System.out.println("Zero-sum subarray does NOT exist");
        }

        sc.close();
    }
}
