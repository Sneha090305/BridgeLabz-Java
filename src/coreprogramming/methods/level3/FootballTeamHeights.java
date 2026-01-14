package coreprogramming.methods.level3;

import java.util.Random;

public class FootballTeamHeights {

    static int[] generateHeights() {
        int[] heights = new int[11];
        Random r = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + r.nextInt(101); // 150–250
        }
        return heights;
    }

    static int sum(int[] arr) {
        int s = 0;
        for (int x : arr) s += x;
        return s;
    }

    static double mean(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    static int shortest(int[] arr) {
        int min = arr[0];
        for (int x : arr)
            if (x < min) min = x;
        return min;
    }

    static int tallest(int[] arr) {
        int max = arr[0];
        for (int x : arr)
            if (x > max) max = x;
        return max;
    }

    public static void main(String[] args) {

        int[] heights = generateHeights();

        System.out.print("Heights: ");
        for (int h : heights) System.out.print(h + " ");

        System.out.println("\nShortest Height = " + shortest(heights));
        System.out.println("Tallest Height = " + tallest(heights));
        System.out.println("Mean Height = " + mean(heights));
    }
}

