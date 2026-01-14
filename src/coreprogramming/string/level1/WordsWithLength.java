package coreprogramming.string.level2;

import java.util.Scanner;

public class WordsWithLength {

    public static String[][] getWordsWithLength(String text) {
        String[] words = text.split(" ");
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String text = sc.nextLine();

        String[][] data = getWordsWithLength(text);

        System.out.println("Word\tLength");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }

        sc.close();
    }
}
