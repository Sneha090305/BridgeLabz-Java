package oops.encapsulation;

import java.util.Scanner;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {

    private String itemName;
    protected double price;
    protected int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name : " + itemName);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total     : " + calculateTotalPrice());
    }
}

class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double calculateTotalPrice() {
        return price * quantity;
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    public String getDiscountDetails() {
        return "10% Veg Discount";
    }
}

class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public double calculateTotalPrice() {
        return (price * quantity) + 50;
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "5% Non-Veg Discount";
    }
}

public class FoodDeliveryMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        System.out.println("1. Veg Item");
        System.out.println("2. Non-Veg Item");
        System.out.print("Choose Item Type: ");
        int choice = sc.nextInt();

        FoodItem item;

        if (choice == 1) {
            item = new VegItem(name, price, qty);
        } else {
            item = new NonVegItem(name, price, qty);
        }

        Discountable d = (Discountable) item;

        System.out.println("\n---- Order Details ----");
        item.getItemDetails();
        System.out.println("Discount : " + d.applyDiscount());
        System.out.println("Offer    : " + d.getDiscountDetails());
        System.out.println("Final    : " + (item.calculateTotalPrice() - d.applyDiscount()));

        sc.close();
    }
}
