package coreprogramming.string.extra1;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (result.indexOf(ch) == -1)
                result += ch;
        }

        System.out.println("Result: " + result);
    }
}
