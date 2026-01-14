package oops.statics.level1;

import java.util.Scanner;

public class Patient {

    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    private String name;
    private int age;
    private String ailment;
    private final int patientID;

    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void display(Object obj) {
        if (obj instanceof Patient) {
            System.out.println("Name  : " + name);
            System.out.println("Age   : " + age);
            System.out.println("Issue : " + ailment);
            System.out.println("ID    : " + patientID);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patient p = new Patient("Sneha", 21, "Fever", 501);
        p.display(p);
        getTotalPatients();
        sc.close();
    }
}
