package coreprogramming.methods.level1;

import java.util.Scanner;

class ChocolatesDistribution {

    static int[] distributeChocolates(int chocolates, int children) {
        return new int[]{chocolates / children, chocolates % children};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter children: ");
        int children = sc.nextInt();

        int[] result = distributeChocolates(chocolates, children);

        System.out.println("Each child gets " + result[0] + " chocolates");
        System.out.println("Remaining chocolates " + result[1]);

        sc.close();
    }
}

