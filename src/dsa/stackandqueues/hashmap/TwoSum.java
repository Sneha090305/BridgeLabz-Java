import java.util.HashMap;
import java.util.Scanner;

class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element at index " + i + ": ");
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        if (result != null) {
            System.out.println("Indices are: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No valid pair found");
        }

        sc.close();
    }
}
