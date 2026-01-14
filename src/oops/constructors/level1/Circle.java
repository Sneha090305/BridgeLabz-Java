package oops.constructors.level1;

import java.util.Scanner;

public class Circle {

    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void display() {
        System.out.println("Radius : " + radius);
        System.out.println("Area   : " + calculateArea());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        Circle circle = new Circle(radius);
        circle.display();

        sc.close();
    }
}
