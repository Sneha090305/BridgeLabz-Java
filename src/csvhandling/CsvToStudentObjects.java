package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvToStudentObjects {

    public static void main(String[] args) {

        String fileName = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] d = line.split(",");

                Student s = new Student(
                        Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        Integer.parseInt(d[3])
                );

                students.add(s);
            }

        } catch (IOException e) {
            System.out.println("Read error");
            e.printStackTrace();
        }

        System.out.println("Student Objects List:");

        for (Student s : students) {
            System.out.println(s);
        }
    }
}