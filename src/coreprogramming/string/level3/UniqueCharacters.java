package coreprogramming.string.level3;

import java.util.Scanner;

public class UniqueCharacters {

    public static char[] findUnique(String text) {
        char[] temp = new char[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean found = false;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[count++] = ch;
            }
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char[] unique = findUnique(text);

        System.out.print("Unique characters: ");
        for (char c : unique) {
            System.out.print(c + " ");
        }

        sc.close();
    }
}

