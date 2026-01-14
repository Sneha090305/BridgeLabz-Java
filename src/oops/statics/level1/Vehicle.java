package oops.statics.level1;

import java.util.Scanner;

public class Vehicle {

    static double registrationFee = 2000;

    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void display(Object obj) {
        if (obj instanceof Vehicle) {
            System.out.println("Owner : " + ownerName);
            System.out.println("Type  : " + vehicleType);
            System.out.println("RegNo : " + registrationNumber);
            System.out.println("Fee   : " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle v = new Vehicle("Sneha", "Car", "TN01AB1234");
        v.display(v);
        sc.close();
    }
}
