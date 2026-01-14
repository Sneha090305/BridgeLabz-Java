package coreprogramming.programmingelements.level1;

import java.util.Scanner;

public class FeetToYardsAndMiles {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();

        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;

        System.out.println(
                "The distance in feet is " + distanceInFeet +
                        " which is equal to " + distanceInYards + " yards and " +
                        distanceInMiles + " miles"
        );

        input.close();
    }
}
