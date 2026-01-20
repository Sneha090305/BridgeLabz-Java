package dsa.linkedlist;

import java.util.Scanner;

class StudentNode {
    int rollNo;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecord {

    private StudentNode head;

    public void addAtBeginning(int rollNo, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int rollNo, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtPosition(int position, int rollNo, String name, int age, String grade) {
        if (position == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        StudentNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void searchByRollNo(int rollNo) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                displayStudent(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public void updateGrade(int rollNo, String newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records");
            return;
        }
        StudentNode temp = head;
        while (temp != null) {
            displayStudent(temp);
            temp = temp.next;
        }
    }

    private void displayStudent(StudentNode s) {
        System.out.println("Roll No : " + s.rollNo);
        System.out.println("Name    : " + s.name);
        System.out.println("Age     : " + s.age);
        System.out.println("Grade   : " + s.grade);
        System.out.println("---------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentRecord record = new StudentRecord();

        while (true) {
            System.out.println("\n1 Add at Beginning");
            System.out.println("2 Add at End");
            System.out.println("3 Add at Position");
            System.out.println("4 Delete by Roll No");
            System.out.println("5 Search by Roll No");
            System.out.println("6 Update Grade");
            System.out.println("7 Display All");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0)
                break;

            int rollNo, age, pos;
            String name, grade;

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    grade = sc.nextLine();
                    record.addAtBeginning(rollNo, name, age, grade);
                    break;

                case 2:
                    System.out.print("Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    grade = sc.nextLine();
                    record.addAtEnd(rollNo, name, age, grade);
                    break;

                case 3:
                    System.out.print("Position: ");
                    pos = sc.nextInt();
                    System.out.print("Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: ");
                    grade = sc.nextLine();
                    record.addAtPosition(pos, rollNo, name, age, grade);
                    break;

                case 4:
                    System.out.print("Roll No: ");
                    rollNo = sc.nextInt();
                    record.deleteByRollNo(rollNo);
                    break;

                case 5:
                    System.out.print("Roll No: ");
                    rollNo = sc.nextInt();
                    record.searchByRollNo(rollNo);
                    break;

                case 6:
                    System.out.print("Roll No: ");
                    rollNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Grade: ");
                    grade = sc.nextLine();
                    record.updateGrade(rollNo, grade);
                    break;

                case 7:
                    record.displayAll();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
