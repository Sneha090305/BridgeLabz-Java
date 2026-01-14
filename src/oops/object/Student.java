package oops.object;

import java.util.*;

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course course) {
        courses.add(course);
        course.students.add(this);
    }
}

class Course {
    String courseName;
    List<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }
}

class School {
    public static void main(String[] args) {
        Student s1 = new Student("Asha");
        Student s2 = new Student("Ravi");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c1);

        System.out.println("Students in Math:");
        for (Student s : c1.students) {
            System.out.println(s.name);
        }
    }
}
