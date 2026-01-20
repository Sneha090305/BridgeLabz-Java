package oops.encapsulation.ride;

import java.util.Scanner;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

abstract class Vehicle {

    private int vehicleId;
    private String driverName;
    protected double ratePerKm;

    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID   : " + vehicleId);
        System.out.println("Driver Name : " + driverName);
        System.out.println("Rate / Km   : " + ratePerKm);
    }
}

class Car extends Vehicle implements GPS {

    private String location = "Unknown";

    public Car(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class Bike extends Vehicle implements GPS {

    private String location = "Unknown";

    public Bike(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return distance * ratePerKm * 0.8;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

class Auto extends Vehicle implements GPS {

    private String location = "Unknown";

    public Auto(int id, String driver, double rate) {
        super(id, driver, rate);
    }

    public double calculateFare(double distance) {
        return distance * ratePerKm * 0.9;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String location) {
        this.location = location;
    }
}

public class RideHailingMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Driver Name: ");
        String driver = sc.nextLine();

        System.out.print("Enter Rate per Km: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Distance: ");
        double distance = sc.nextDouble();
        sc.nextLine();

        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Auto");
        System.out.print("Choose Vehicle Type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        Vehicle vehicle;

        if (choice == 1) {
            vehicle = new Car(id, driver, rate);
        } else if (choice == 2) {
            vehicle = new Bike(id, driver, rate);
        } else {
            vehicle = new Auto(id, driver, rate);
        }

        GPS gps = (GPS) vehicle;

        System.out.print("Enter Current Location: ");
        String location = sc.nextLine();
        gps.updateLocation(location);

        System.out.println("\n---- Ride Details ----");
        vehicle.getVehicleDetails();
        System.out.println("Location    : " + gps.getCurrentLocation());
        System.out.println("Fare        : " + vehicle.calculateFare(distance));

        sc.close();
    }
}
