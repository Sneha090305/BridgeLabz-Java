import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt");

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

            in.close();
            out.close();
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.out.println("Source file not found or error occurred");
        }
    }
}
