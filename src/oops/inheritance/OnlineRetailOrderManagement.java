import java.util.Scanner;

public class OnlineRetailOrderManagement {

    static class Order {
        int orderId;
        String orderDate;

        Order(int orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }
    }

    static class ShippedOrder extends Order {
        String trackingNumber;

        ShippedOrder(int orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        String deliveryDate;

        DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        String getOrderStatus() {
            return "Order Delivered on: " + deliveryDate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Order ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Order Date: ");
        String orderDate = sc.nextLine();

        System.out.print("Enter Tracking Number: ");
        String tracking = sc.nextLine();

        System.out.print("Enter Delivery Date: ");
        String deliveryDate = sc.nextLine();

        DeliveredOrder order =
                new DeliveredOrder(id, orderDate, tracking, deliveryDate);

        System.out.println("\n--- Order Status ---");
        System.out.println(order.getOrderStatus());

        sc.close();
    }
}
