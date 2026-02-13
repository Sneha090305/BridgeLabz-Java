package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CsvSearchEmployee {

    public static void main(String[] args) {

        String fileName = "employees.csv";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine().trim();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[1];

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Found Employee:");
                    System.out.println("Department: " + data[2]);
                    System.out.println("Salary: " + data[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading employees.csv");
            e.printStackTrace();
        }

        sc.close();
    }
}