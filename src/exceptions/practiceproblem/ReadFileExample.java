import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("user_details.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
