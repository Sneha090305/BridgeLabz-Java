package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CsvDetectDuplicates {

    public static void main(String[] args) {

        String fileName = "employees.csv";
        Set<String> seenIds = new HashSet<>();
        boolean duplicateFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String id = data[0];

                if (!seenIds.add(id)) {
                    System.out.println("Duplicate record found: " + line);
                    duplicateFound = true;
                }
            }

            if (!duplicateFound) {
                System.out.println("No duplicate IDs found.");
            }

        } catch (IOException e) {
            System.out.println("Read error.");
            e.printStackTrace();
        }
    }
}