package coreprogramming.controlflow.level1;

import java.util.Scanner;

class RocketLaunchCountdown {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.print("Enter countdown start number: ");
        int counter = input.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println(" Launch!");

        input.close();
    }
}
