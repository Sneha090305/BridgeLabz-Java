package coreprogramming.string.level1;

import java.util.Scanner;

public class CompareStrings {

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String a = sc.next();

        System.out.print("Enter second string: ");
        String b = sc.next();

        boolean charResult = compareUsingCharAt(a, b);
        boolean equalsResult = a.equals(b);

        System.out.println("Using charAt(): " + charResult);
        System.out.println("Using equals(): " + equalsResult);

        sc.close();
    }
}
