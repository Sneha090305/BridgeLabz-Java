package csvhandling;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CsvMergeFiles {

    public static void main(String[] args) {

        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String output = "students_merged.csv";

        Map<String, String[]> marksMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                String id = d[0].trim();
                marksMap.put(id, new String[]{d[1].trim(), d[2].trim()});
            }

        } catch (IOException e) {
            System.out.println("Error reading file2");
            return;
        }

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedWriter bw = new BufferedWriter(new FileWriter(output))
        ) {

            String line;

            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();

            br1.readLine();

            while ((line = br1.readLine()) != null) {

                String[] d = line.split(",");
                String id = d[0].trim();

                if (marksMap.containsKey(id)) {
                    String[] extra = marksMap.get(id);

                    bw.write(
                            id + "," +
                                    d[1].trim() + "," +
                                    d[2].trim() + "," +
                                    extra[0] + "," +
                                    extra[1]
                    );
                    bw.newLine();
                }
            }

            System.out.println("Merged file created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}