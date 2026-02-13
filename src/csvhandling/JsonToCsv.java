package csvhandling;

import java.io.*;

public class JsonToCsv {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("from_json.csv"));

        bw.write("id,name,age");
        bw.newLine();

        String line;

        while ((line = br.readLine()) != null) {

            line = line.trim();

            if (line.startsWith("{")) {

                line = line.replaceAll("[{}\"]", "");
                String[] parts = line.split(",");

                String id = parts[0].split(":")[1];
                String name = parts[1].split(":")[1];
                String age = parts[2].split(":")[1];

                bw.write(id + "," + name + "," + age);
                bw.newLine();
            }
        }

        br.close();
        bw.close();

        System.out.println("CSV created from JSON.");
    }
}