package coreprogramming.string.extra1;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean isPalindrome = true;
        int start = 0, end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }
}
