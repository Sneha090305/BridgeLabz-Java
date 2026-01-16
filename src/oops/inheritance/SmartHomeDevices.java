import java.util.Scanner;

public class SmartHomeDevices {

    static class Device {
        String deviceId;
        String status;

        Device(String deviceId, String status) {
            this.deviceId = deviceId;
            this.status = status;
        }
    }

    static class Thermostat extends Device {
        int temperatureSetting;

        Thermostat(String deviceId, String status, int temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        void displayStatus() {
            System.out.println("Device ID: " + deviceId);
            System.out.println("Status: " + status);
            System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter device ID: ");
        String id = sc.nextLine();

        System.out.print("Enter device status (ON/OFF): ");
        String status = sc.nextLine();

        System.out.print("Enter temperature setting: ");
        int temp = sc.nextInt();

        Thermostat thermostat = new Thermostat(id, status, temp);

        System.out.println("\n--- Device Status ---");
        thermostat.displayStatus();

        sc.close();
    }
}
