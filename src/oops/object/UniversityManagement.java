import java.util.*;

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }

    void assignProfessor(Course c) {
        c.professor = this;
    }
}

class Course {
    String name;
    Professor professor;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void enroll(Student s) {
        students.add(s);
    }
}

public class UniversityManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        Student s = new Student(sc.nextLine());

        System.out.print("Enter professor name: ");
        Professor p = new Professor(sc.nextLine());

        System.out.print("Enter course name: ");
        Course c = new Course(sc.nextLine());

        p.assignProfessor(c);
        c.enroll(s);

        System.out.println("Course: " + c.name);
        System.out.println("Professor: " + c.professor.name);
        System.out.println("Student enrolled: " + s.name);
    }
}
