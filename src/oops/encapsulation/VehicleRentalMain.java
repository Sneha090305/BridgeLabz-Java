package oops.encapsulation;

import java.util.Scanner;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {

    private String vehicleNumber;
    private String type;
    protected double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails(int days) {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + type);
        System.out.println("Rental Cost    : " + calculateRentalCost(days));
    }
}

class Car extends Vehicle implements Insurable {

    public Car(String number, double rate) {
        super(number, "Car", rate);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 500;
    }

    public String getInsuranceDetails() {
        return "Car Insurance";
    }
}

class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate) {
        super(number, "Bike", rate);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 200;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance";
    }
}

class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate) {
        super(number, "Truck", rate);
    }

    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    public double calculateInsurance() {
        return 1000;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance";
    }
}

public class VehicleRentalMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Enter Rental Rate per Day: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        System.out.print("Choose Vehicle Type: ");
        int choice = sc.nextInt();

        Vehicle vehicle;

        if (choice == 1) {
            vehicle = new Car(number, rate);
        } else if (choice == 2) {
            vehicle = new Bike(number, rate);
        } else {
            vehicle = new Truck(number, rate);
        }

        System.out.println("\n---- Vehicle Details ----");
        vehicle.displayDetails(days);

        Insurable ins = (Insurable) vehicle;
        System.out.println("Insurance Cost : " + ins.calculateInsurance());
        System.out.println("Insurance Type : " + ins.getInsuranceDetails());

        sc.close();
    }
}
