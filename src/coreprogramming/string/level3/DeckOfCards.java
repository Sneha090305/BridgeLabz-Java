package coreprogramming.string.level3;

import java.util.Scanner;

public class DeckOfCards {

    public static void main(String[] args) {

        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

        int total = suits.length * ranks.length;
        String[] deck = new String[total];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        for (int i = 0; i < deck.length; i++) {
            int r = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = sc.nextInt();

        int cardsPerPlayer = deck.length / players;
        int k = 0;

        for (int i = 1; i <= players; i++) {
            System.out.println("Player " + i + ":");
            for (int j = 0; j < cardsPerPlayer; j++) {
                System.out.println(deck[k++]);
            }
            System.out.println();
        }

        sc.close();
    }
}
