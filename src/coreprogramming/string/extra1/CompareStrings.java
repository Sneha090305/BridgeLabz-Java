package coreprogramming.string.extra1;

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String a = sc.next();
        System.out.print("Enter second string: ");
        String b = sc.next();

        int i = 0;
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i))
            i++;

        if (i == a.length() && i == b.length())
            System.out.println("Strings are equal");
        else if (i == a.length() || (i < b.length() && a.charAt(i) < b.charAt(i)))
            System.out.println(a + " comes before " + b);
        else
            System.out.println(b + " comes before " + a);
    }
}
