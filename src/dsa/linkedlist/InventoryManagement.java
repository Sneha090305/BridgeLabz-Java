package dsa.linkedlist;

import java.util.Scanner;

class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {

    private ItemNode head;

    public void addAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void removeByItemId(int id) {
        if (head == null) {
            System.out.println("Inventory is empty");
            return;
        }
        if (head.itemId == id) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No items available");
            return;
        }
        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    public void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    private void displayItem(ItemNode i) {
        System.out.println("Item ID   : " + i.itemId);
        System.out.println("Name      : " + i.itemName);
        System.out.println("Quantity  : " + i.quantity);
        System.out.println("Price     : " + i.price);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryManagement inventory = new InventoryManagement();

        while (true) {
            System.out.println("\n1 Add at Beginning");
            System.out.println("2 Add at End");
            System.out.println("3 Remove by Item ID");
            System.out.println("4 Update Quantity");
            System.out.println("5 Search by Item ID");
            System.out.println("6 Search by Item Name");
            System.out.println("7 Display All Items");
            System.out.println("8 Total Inventory Value");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0)
                break;

            int id, qty;
            String name;
            double price;

            switch (choice) {
                case 1:
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    inventory.addAtBeginning(id, name, qty, price);
                    break;

                case 2:
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Item Name: ");
                    name = sc.nextLine();
                    System.out.print("Quantity: ");
                    qty = sc.nextInt();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    inventory.addAtEnd(id, name, qty, price);
                    break;

                case 3:
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    inventory.removeByItemId(id);
                    break;

                case 4:
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    System.out.print("New Quantity: ");
                    qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                    break;

                case 5:
                    System.out.print("Item ID: ");
                    id = sc.nextInt();
                    inventory.searchById(id);
                    break;

                case 6:
                    System.out.print("Item Name: ");
                    name = sc.nextLine();
                    inventory.searchByName(name);
                    break;

                case 7:
                    inventory.displayAll();
                    break;

                case 8:
                    inventory.totalInventoryValue();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
