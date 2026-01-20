package oops.encapsulation;

import java.util.Scanner;

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

abstract class Patient {

    private int patientId;
    private String name;
    private int age;
    protected String medicalHistory = "";

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Bill       : " + calculateBill());
    }
}

class InPatient extends Patient implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }

    public String viewRecords() {
        return medicalHistory;
    }
}

class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        medicalHistory += record + "; ";
    }

    public String viewRecords() {
        return medicalHistory;
    }
}

public class HospitalMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.println("1. In-Patient");
        System.out.println("2. Out-Patient");
        System.out.print("Choose Patient Type: ");
        int choice = sc.nextInt();
        sc.nextLine();

        Patient patient;

        if (choice == 1) {
            System.out.print("Enter Days Admitted: ");
            int days = sc.nextInt();

            System.out.print("Enter Daily Charge: ");
            double charge = sc.nextDouble();
            sc.nextLine();

            patient = new InPatient(id, name, age, days, charge);
        } else {
            System.out.print("Enter Consultation Fee: ");
            double fee = sc.nextDouble();
            sc.nextLine();

            patient = new OutPatient(id, name, age, fee);
        }

        MedicalRecord mr = (MedicalRecord) patient;

        System.out.print("Add Medical Record: ");
        String record = sc.nextLine();
        mr.addRecord(record);

        System.out.println("\n---- Patient Details ----");
        patient.getPatientDetails();
        System.out.println("Medical History : " + mr.viewRecords());

        sc.close();
    }
}
