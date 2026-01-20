package oops.encapsulation;

import java.util.Scanner;

interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

abstract class Employee {

    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Salary      : " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee implements Department {

    private String department;

    public FullTimeEmployee(int id, String name, double salary) {
        super(id, name, salary);
    }

    public double calculateSalary() {
        return getBaseSalary();
    }

    public void assignDepartment(String dept) {
        department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

class PartTimeEmployee extends Employee implements Department {

    private int hoursWorked;
    private double ratePerHour;
    private String department;

    public PartTimeEmployee(int id, String name, int hoursWorked, double ratePerHour) {
        super(id, name, 0);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public double calculateSalary() {
        return hoursWorked * ratePerHour;
    }

    public void assignDepartment(String dept) {
        department = dept;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

public class EmployeeMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FullTimeEmployee fte = new FullTimeEmployee(1, "Alice", 50000);
        fte.assignDepartment("IT");

        PartTimeEmployee pte = new PartTimeEmployee(2, "Bob", 20, 500);
        pte.assignDepartment("HR");

        System.out.println("---- Full Time Employee ----");
        fte.displayDetails();
        System.out.println("Department : " + fte.getDepartmentDetails());

        System.out.println();

        System.out.println("---- Part Time Employee ----");
        pte.displayDetails();
        System.out.println("Department : " + pte.getDepartmentDetails());

        sc.close();
    }
}
