package dsa.linkedlist;

import java.util.Scanner;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservation {

    private TicketNode head;

    public void addTicket(int id, String customer, String movie, int seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        TicketNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = head;
        TicketNode prev = null;

        do {
            if (temp.ticketId == id) {
                if (prev == null) {
                    TicketNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    if (head == head.next) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket removed");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found");
    }

    public void searchByCustomer(String customer) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customer)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for customer");
    }

    public void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets available");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for movie");
    }

    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets: " + count);
    }

    private void displayTicket(TicketNode t) {
        System.out.println("Ticket ID    : " + t.ticketId);
        System.out.println("Customer     : " + t.customerName);
        System.out.println("Movie        : " + t.movieName);
        System.out.println("Seat Number  : " + t.seatNumber);
        System.out.println("Booking Time : " + t.bookingTime);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketReservation system = new TicketReservation();

        while (true) {
            System.out.println("\n1 Book Ticket");
            System.out.println("2 Remove Ticket");
            System.out.println("3 Search by Customer");
            System.out.println("4 Search by Movie");
            System.out.println("5 Display All Tickets");
            System.out.println("6 Count Tickets");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0)
                break;

            int id, seat;
            String customer, movie, time;

            switch (choice) {
                case 1:
                    System.out.print("Ticket ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    customer = sc.nextLine();
                    System.out.print("Movie Name: ");
                    movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    seat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Booking Time: ");
                    time = sc.nextLine();
                    system.addTicket(id, customer, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Ticket ID: ");
                    id = sc.nextInt();
                    system.removeTicket(id);
                    break;

                case 3:
                    System.out.print("Customer Name: ");
                    customer = sc.nextLine();
                    system.searchByCustomer(customer);
                    break;

                case 4:
                    System.out.print("Movie Name: ");
                    movie = sc.nextLine();
                    system.searchByMovie(movie);
                    break;

                case 5:
                    system.displayAllTickets();
                    break;

                case 6:
                    system.countTickets();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
