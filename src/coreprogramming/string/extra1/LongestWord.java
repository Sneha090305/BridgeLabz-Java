package coreprogramming.string.extra1;

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] words = text.split(" ");
        String longest = words[0];

        for (String word : words) {
            if (word.length() > longest.length())
                longest = word;
        }

        System.out.println("Longest word: " + longest);
    }
}
