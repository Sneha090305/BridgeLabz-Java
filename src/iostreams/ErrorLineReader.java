import java.io.*;

public class ErrorLineReader {
    public static void main(String[] args) {


        String path = "large.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }

            System.out.println("Done reading file.");

        } catch (FileNotFoundException e) {
            System.out.println("File NOT found: " + path);
        } catch (IOException e) {
            System.out.println("Error while reading file.");
        }
    }
}
