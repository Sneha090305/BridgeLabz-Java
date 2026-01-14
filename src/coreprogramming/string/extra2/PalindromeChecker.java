package coreprogramming.string.extra2;

import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        if (isPalindrome(text))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
