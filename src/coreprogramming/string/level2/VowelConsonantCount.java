package coreprogramming.string.level2;

import java.util.Scanner;

public class VowelConsonantCount {

    public static int[] countShow(String text) {
        int v = 0, c = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);

            if (ch >= 'a' && ch <= 'z') {
                if ("aeiou".indexOf(ch) >= 0) v++;
                else c++;
            }
        }
        return new int[]{v, c};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] res = countShow(text);
        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);

        sc.close();
    }
}
