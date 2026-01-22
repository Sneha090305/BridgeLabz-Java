package linearbinary;
import java.util.Arrays;

public class mixingPositiveBinarySearch {


    static int missPos(int[] a) {
        int n = a.length;
        boolean[] seen = new boolean[n + 1];

        for (int x : a)
            if (x > 0 && x <= n)
                seen[x] = true;

        for (int i = 1; i <= n; i++)
            if (!seen[i])
                return i;

        return n + 1;
    }

    static int bin(int[] a, int t) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == t)
                return m;
            if (a[m] < t)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, -1, 1};
        int t = 4;

        System.out.println(missPos(a));

        Arrays.sort(a);
        System.out.println(bin(a, t));
    }
}

