package csvhandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriteData {

    public static void main(String[] args) {

        String fileName = "employees.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            // write header
            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            // write records
            bw.write("1,Amit,IT,60000");
            bw.newLine();

            bw.write("2,Riya,HR,50000");
            bw.newLine();

            bw.write("3,Karan,Finance,70000");
            bw.newLine();

            bw.write("4,Neha,IT,65000");
            bw.newLine();

            bw.write("5,Rohit,Sales,55000");
            bw.newLine();

            System.out.println("employees.csv file created successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file.");
            e.printStackTrace();
        }
    }
}