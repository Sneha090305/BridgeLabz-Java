package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CsvSortBySalary {

    static class Employee {
        int id;
        String name;
        String dept;
        int salary;

        Employee(int id, String name, String dept, int salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        String fileName = "employees.csv";
        List<Employee> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                list.add(new Employee(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Integer.parseInt(d[3])
                ));
            }

        } catch (IOException e) {
            System.out.println("Read error");
            e.printStackTrace();
        }

        // sort by salary descending
        Collections.sort(list, Comparator.comparingInt(e -> -e.salary));

        System.out.println("Top highest paid employees:");

        int limit = Math.min(5, list.size());

        for (int i = 0; i < limit; i++) {
            Employee e = list.get(i);
            System.out.println(
                    e.id + " | " +
                            e.name + " | " +
                            e.dept + " | " +
                            e.salary
            );
        }
    }
}