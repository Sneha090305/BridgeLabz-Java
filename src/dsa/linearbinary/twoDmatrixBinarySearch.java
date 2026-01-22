package linearbinary;

public class twoDmatrixBinarySearch {


    static boolean find(int[][] a, int t) {
        int r = a.length;
        int c = a[0].length;
        int l = 0, h = r * c - 1;

        while (l <= h) {
            int m = (l + h) / 2;
            int x = a[m / c][m % c];

            if (x == t)
                return true;
            if (x < t)
                l = m + 1;
            else
                h = m - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println(find(a, 16));
        System.out.println(find(a, 13));
    }
}
