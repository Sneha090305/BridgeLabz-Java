package coreprogramming.string.level2;

import java.util.Scanner;

public class ShortestLongestWord {

    public static String[] findShortestLongest(String[] words) {
        String shortest = words[0];
        String longest = words[0];

        for (String w : words) {
            if (w.length() < shortest.length()) shortest = w;
            if (w.length() > longest.length()) longest = w;
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[] words = text.split(" ");
        String[] result = findShortestLongest(words);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);

        sc.close();
    }
}
