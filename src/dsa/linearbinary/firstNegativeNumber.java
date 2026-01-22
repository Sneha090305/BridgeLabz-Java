package linearbinary;

public class firstNegativeNumber {

    static int find(int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] < 0)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 3, -2, 7, -9};

        System.out.println(find(a));
    }
}
