package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvBasicRead {

    public static void main(String[] args) {

        String filePath = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;

            // skip header
            br.readLine();

            System.out.println("Student Records:");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println(
                        "ID: " + data[0] +
                                " Name: " + data[1] +
                                " Age: " + data[2] +
                                " Marks: " + data[3]
                );
            }

        } catch (IOException e) {
            System.out.println("students.csv file not found — create it first.");
        }
    }
}