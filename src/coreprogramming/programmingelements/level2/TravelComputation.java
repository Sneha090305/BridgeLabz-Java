package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class TravelComputation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter from city: ");
        String fromCity = input.nextLine();

        System.out.print("Enter via city: ");
        String viaCity = input.nextLine();

        System.out.print("Enter to city: ");
        String toCity = input.nextLine();

        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double distanceFromToVia = input.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (in miles): ");
        double distanceViaToFinal = input.nextDouble();

        System.out.print("Enter hours taken from " + fromCity + " to " + viaCity + ": ");
        int hours1 = input.nextInt();

        System.out.print("Enter minutes taken from " + fromCity + " to " + viaCity + ": ");
        int minutes1 = input.nextInt();

        System.out.print("Enter hours taken from " + viaCity + " to " + toCity + ": ");
        int hours2 = input.nextInt();

        System.out.print("Enter minutes taken from " + viaCity + " to " + toCity + ": ");
        int minutes2 = input.nextInt();

        double totalDistance = distanceFromToVia + distanceViaToFinal;
        int totalTimeInMinutes = (hours1 * 60 + minutes1) + (hours2 * 60 + minutes2);

        System.out.println(
                "The Total Distance travelled by " + name + " from " +
                        fromCity + " to " + toCity + " via " + viaCity +
                        " is " + totalDistance + " miles and the Total Time taken is " +
                        totalTimeInMinutes + " minutes"
        );

        input.close();
    }
}
