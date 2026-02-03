import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class FileProcessor {

    public void processFiles(List<String> filePaths) {

        for (String path : filePaths) {
            System.out.println("\nReading file: " + path);

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
            }
        }
    }
}

public class FileProcessorMain {

    public static void main(String[] args) {

        FileProcessor fp = new FileProcessor();

        List<String> files = Arrays.asList(
                "user_details.txt",
                "info.txt",
                "missing.txt"
        );

        fp.processFiles(files);
    }
}
