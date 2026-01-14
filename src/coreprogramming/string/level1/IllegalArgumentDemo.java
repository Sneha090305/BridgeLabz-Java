package coreprogramming.string.level1;

import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateException(String text) {
        if (text.length() < 3) {
            throw new IllegalArgumentException("Text too short");
        }
        throw new IllegalArgumentException("Start index greater than end index");
    }

    public static void handleException(String text) {
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        handleException(text);

        sc.close();
    }
}
