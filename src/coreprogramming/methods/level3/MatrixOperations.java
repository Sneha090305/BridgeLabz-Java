package coreprogramming.methods.level3;


public class MatrixOperations {

    public static int[][] createMatrix(int r, int c) {
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = (int)(Math.random() * 10);
            }
        }
        return m;
    }

    public static void display(int[][] m) {
        for (int[] row : m) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static int[][] add(int[][] a, int[][] b) {
        int[][] r = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                r[i][j] = a[i][j] + b[i][j];
        return r;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] r = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++)
                for (int k = 0; k < b.length; k++)
                    r[i][j] += a[i][k] * b[k][j];
        return r;
    }

    public static void main(String[] args) {

        int[][] A = createMatrix(2,2);
        int[][] B = createMatrix(2,2);

        System.out.println("Matrix A:");
        display(A);

        System.out.println("Matrix B:");
        display(B);

        System.out.println("Addition:");
        display(add(A,B));

        System.out.println("Multiplication:");
        display(multiply(A,B));
    }
}
