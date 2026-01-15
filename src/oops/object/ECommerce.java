import java.util.*;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

class Order {
    List<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }

    Order placeOrder() {
        System.out.println(name + " placed an order");
        return new Order();
    }
}

public class ECommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        Customer c = new Customer(sc.nextLine());

        System.out.print("Enter product name: ");
        Product p = new Product(sc.nextLine());

        Order o = c.placeOrder();
        o.addProduct(p);

        System.out.println("Product added to order.");
    }
}
