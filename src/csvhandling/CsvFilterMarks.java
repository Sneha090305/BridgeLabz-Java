package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFilterMarks {

    public static void main(String[] args) {

        String fileName = "students.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // skip header
            br.readLine();

            System.out.println("Students scoring more than 80:");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {
                    System.out.println(
                            data[0] + " | " +
                                    data[1] + " | " +
                                    data[2] + " | " +
                                    data[3]
                    );
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading students.csv");
            e.printStackTrace();
        }
    }
}