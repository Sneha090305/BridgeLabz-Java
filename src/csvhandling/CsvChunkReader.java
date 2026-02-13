package csvhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvChunkReader {

    public static void main(String[] args) {

        String fileName = "employees.csv";
        int chunkSize = 100;

        List<String> buffer = new ArrayList<>();
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                buffer.add(line);

                if (buffer.size() == chunkSize) {
                    processChunk(buffer);
                    totalProcessed += buffer.size();
                    buffer.clear();
                }
            }

            // process remaining lines
            if (!buffer.isEmpty()) {
                processChunk(buffer);
                totalProcessed += buffer.size();
            }

            System.out.println("Total records processed: " + totalProcessed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void processChunk(List<String> chunk) {
        System.out.println("Processing chunk of size: " + chunk.size());
        // here you would do real processing
    }
}