package coreprogramming.string.level2;

import java.util.Scanner;

public class CharacterType {

    public static String check(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);

        if (ch < 'a' || ch > 'z') return "Not a Letter";
        if ("aeiou".indexOf(ch) >= 0) return "Vowel";
        return "Consonant";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter character: ");
        char ch = sc.next().charAt(0);

        System.out.println("Type: " + check(ch));

        sc.close();
    }
}

