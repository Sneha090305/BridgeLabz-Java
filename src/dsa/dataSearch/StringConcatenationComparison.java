package dsa.strings;

import java.util.Scanner;

public class StringConcatenationComparison {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of concatenations: ");
        int n = sc.nextInt();


        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + "a";
        }
        long end = System.nanoTime();
        System.out.println("\nString Time (ns): " + (end - start));


        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time (ns): " + (end - start));


        start = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time (ns): " + (end - start));

        sc.close();
    }
}
