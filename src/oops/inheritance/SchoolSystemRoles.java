import java.util.Scanner;

public class SchoolSystemRoles {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    static class Teacher extends Person {
        String subject;

        Teacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }

        void displayRole() {
            System.out.println("Role: Teacher");
        }
    }

    static class Student extends Person {
        String grade;

        Student(String name, int age, String grade) {
            super(name, age);
            this.grade = grade;
        }

        void displayRole() {
            System.out.println("Role: Student");
        }
    }

    static class Staff extends Person {
        String department;

        Staff(String name, int age, String department) {
            super(name, age);
            this.department = department;
        }

        void displayRole() {
            System.out.println("Role: Staff");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Select role:");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. Staff");
        int choice = sc.nextInt();
        sc.nextLine();

        Person person;

        if (choice == 1) {
            System.out.print("Enter subject: ");
            String subject = sc.nextLine();
            person = new Teacher(name, age, subject);
            ((Teacher) person).displayRole();

        } else if (choice == 2) {
            System.out.print("Enter grade: ");
            String grade = sc.nextLine();
            person = new Student(name, age, grade);
            ((Student) person).displayRole();

        } else {
            System.out.print("Enter department: ");
            String dept = sc.nextLine();
            person = new Staff(name, age, dept);
            ((Staff) person).displayRole();
        }

        sc.close();
    }
}
