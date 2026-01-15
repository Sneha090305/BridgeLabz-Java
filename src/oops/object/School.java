package oops.object;

import java.util.*;

class SchoolStudent {
    String name;
    List<SchoolCourse> courses = new ArrayList<>();

    SchoolStudent(String name) {
        this.name = name;
    }

    void enroll(SchoolCourse c) {
        courses.add(c);
        c.addStudent(this);
    }

    void viewCourses() {
        System.out.println(name + " enrolled in:");
        for (SchoolCourse c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

class SchoolCourse {
    String name;
    List<SchoolStudent> students = new ArrayList<>();

    SchoolCourse(String name) {
        this.name = name;
    }

    void addStudent(SchoolStudent s) {
        students.add(s);
    }

    void viewStudents() {
        System.out.println("Students in " + name + ":");
        for (SchoolStudent s : students) {
            System.out.println("- " + s.name);
        }
    }
}

public class School {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        SchoolStudent student = new SchoolStudent(sc.nextLine());

        System.out.print("Enter course name: ");
        SchoolCourse course = new SchoolCourse(sc.nextLine());

        student.enroll(course);

        System.out.println();
        student.viewCourses();
        course.viewStudents();

        sc.close();
    }
}
