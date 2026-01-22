package linearbinary;

public class firstLastOccuranceBinary {

    static int first(int[] a, int t) {
        int l = 0, r = a.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == t) {
                res = m;
                r = m - 1;
            } else if (a[m] < t)
                l = m + 1;
            else
                r = m - 1;
        }
        return res;
    }

    static int last(int[] a, int t) {
        int l = 0, r = a.length - 1, res = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == t) {
                res = m;
                l = m + 1;
            } else if (a[m] < t)
                l = m + 1;
            else
                r = m - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 4, 5};

        System.out.println(first(a, 2));
        System.out.println(last(a, 2));
        System.out.println(first(a, 6));
    }
}
