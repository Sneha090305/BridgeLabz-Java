package linearbinary;

public class peakElement {

    static int find(int[] a) {
        int n = a.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            boolean leftOk = m == 0 || a[m] > a[m - 1];
            boolean rightOk = m == n - 1 || a[m] > a[m + 1];

            if (leftOk && rightOk)
                return m;
            if (m > 0 && a[m] < a[m - 1])
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 20, 4, 1, 0};

        System.out.println(find(a));
    }
}


