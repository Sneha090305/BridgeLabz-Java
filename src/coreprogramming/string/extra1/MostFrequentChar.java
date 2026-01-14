package coreprogramming.string.extra1;

import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++)
            freq[text.charAt(i)]++;

        char maxChar = text.charAt(0);
        int max = freq[maxChar];

        for (int i = 1; i < text.length(); i++) {
            if (freq[text.charAt(i)] > max) {
                max = freq[text.charAt(i)];
                maxChar = text.charAt(i);
            }
        }

        System.out.println("Most Frequent Character: " + maxChar);
    }
}
