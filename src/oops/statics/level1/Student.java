package oops.statics.level1;

import java.util.Scanner;

public class Student {

    static String universityName = "Anna University";
    static int totalStudents = 0;

    private String name;
    private final int rollNumber;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void display(Object obj) {
        if (obj instanceof Student) {
            System.out.println("Name : " + name);
            System.out.println("Roll : " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student("Sneha", 10, 'A');
        s.display(s);
        displayTotalStudents();
        sc.close();
    }
}
