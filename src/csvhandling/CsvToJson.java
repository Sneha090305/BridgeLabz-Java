package csvhandling;

import java.io.*;

public class CsvToJson {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("from_json.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("back_to_json.json"));

        bw.write("[");
        bw.newLine();

        br.readLine(); // skip header

        String line;
        boolean first = true;

        while ((line = br.readLine()) != null) {

            String[] d = line.split(",");

            if (!first) bw.write(",");
            first = false;

            bw.write("{\"id\":" + d[0] +
                    ",\"name\":\"" + d[1] +
                    "\",\"age\":" + d[2] + "}");
            bw.newLine();
        }

        bw.write("]");
        br.close();
        bw.close();

        System.out.println("JSON created from CSV.");
    }
}