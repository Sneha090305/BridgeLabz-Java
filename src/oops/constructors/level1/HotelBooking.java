package oops.constructors.level1;

import java.util.Scanner;

public class HotelBooking {

    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        this("NA", "Standard", 1);
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this(other.guestName, other.roomType, other.nights);
    }

    public void display() {
        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter guest name: ");
        String guestName = sc.nextLine();

        System.out.print("Enter room type: ");
        String roomType = sc.nextLine();

        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        HotelBooking booking1 = new HotelBooking(guestName, roomType, nights);
        HotelBooking booking2 = new HotelBooking(booking1);

        System.out.println("Original Booking:");
        booking1.display();

        System.out.println("Copied Booking:");
        booking2.display();

        sc.close();
    }
}
