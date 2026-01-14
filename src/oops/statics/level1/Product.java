package oops.statics.level1;

import java.util.Scanner;

public class Product {

    static double discount = 10.0;

    private String productName;
    private double price;
    private int quantity;
    private final int productID;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void display(Object obj) {
        if (obj instanceof Product) {
            System.out.println("Product : " + productName);
            System.out.println("ID      : " + productID);
            System.out.println("Price   : " + price);
            System.out.println("Qty     : " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p = new Product("Laptop", 50000, 1, 101);
        p.display(p);
        sc.close();
    }
}
