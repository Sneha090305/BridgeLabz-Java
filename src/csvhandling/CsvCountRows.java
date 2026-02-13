package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvCountRows {

    public static void main(String[] args) {

        String fileName = "employees.csv";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // skip header
            br.readLine();

            while (br.readLine() != null) {
                count++;
            }

            System.out.println("Total records (excluding header): " + count);

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
    }
}