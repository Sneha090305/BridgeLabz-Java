package csvhandling;

import java.io.*;

public class CsvUpdateSalary {

    public static void main(String[] args) {

        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {

            String line;

            // read and write header
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String dept = data[2];
                double salary = Double.parseDouble(data[3]);

                // increase IT salary by 10%
                if (dept.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

                // rebuild row
                String updatedRow =
                        data[0] + "," +
                                data[1] + "," +
                                data[2] + "," +
                                (int)salary;

                bw.write(updatedRow);
                bw.newLine();
            }

            System.out.println("Updated file created: employees_updated.csv");

        } catch (IOException e) {
            System.out.println("File error.");
            e.printStackTrace();
        }
    }
}