package coreprogramming.string.level2;

import java.util.Scanner;

public class TrimSpaces {

    public static String customTrim(String text) {
        int start = 0, end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;

        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String custom = customTrim(text);
        String builtin = text.trim();

        System.out.println("Result same: " + custom.equals(builtin));

        sc.close();
    }
}
