package oops.constructors.level1;

import java.util.Scanner;

public class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = 1000.0;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public void display() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.println("Total Cost    : " + calculateTotalCost());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter car model: ");
        String carModel = sc.nextLine();

        System.out.print("Enter rental days: ");
        int rentalDays = sc.nextInt();

        CarRental rental = new CarRental(customerName, carModel, rentalDays);
        rental.display();

        sc.close();
    }
}
