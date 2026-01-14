package oops.statics.level1;

import java.util.Scanner;

public class Employee {

    static String companyName = "TechCorp";
    static int totalEmployees = 0;

    private String name;
    private final int id;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void display(Object obj) {
        if (obj instanceof Employee) {
            System.out.println("Name        : " + name);
            System.out.println("ID          : " + id);
            System.out.println("Designation : " + designation);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee e = new Employee("Sneha", 1, "Engineer");
        e.display(e);
        displayTotalEmployees();
        sc.close();
    }
}
