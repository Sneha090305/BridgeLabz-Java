package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvValidateData {

    public static void main(String[] args) {

        String fileName = "users.csv";

        // simple regex patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");

                String email = d[2].trim();
                String phone = d[3].trim();

                boolean emailValid = email.matches(emailRegex);
                boolean phoneValid = phone.matches(phoneRegex);

                if (!emailValid || !phoneValid) {
                    System.out.println("Invalid row → " + line);
                }
            }

            System.out.println("Validation completed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}