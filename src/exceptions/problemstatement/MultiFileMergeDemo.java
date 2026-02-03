import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultiFileMergeDemo {

    public static void main(String[] args) {

        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String output = "combined.txt";

        try (
                BufferedReader br1 = new BufferedReader(new FileReader(file1));
                BufferedReader br2 = new BufferedReader(new FileReader(file2));
                BufferedWriter bw = new BufferedWriter(new FileWriter(output))
        ) {

            String line;

            while ((line = br1.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            while ((line = br2.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Files combined successfully into: " + output);

        } catch (IOException e) {
            System.out.println("Error processing files");
        }
    }
}
