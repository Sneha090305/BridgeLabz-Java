package oops.constructors.level1;

import java.util.Scanner;

public class Person {

    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Person p1 = new Person(name, age);
        Person p2 = new Person(p1);

        System.out.println("Original Person:");
        p1.display();

        System.out.println("Copied Person:");
        p2.display();

        sc.close();
    }
}
