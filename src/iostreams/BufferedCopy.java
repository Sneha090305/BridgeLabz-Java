import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) {
        try {
            BufferedInputStream in =
                    new BufferedInputStream(new FileInputStream("bigfile.dat"));

            BufferedOutputStream out =
                    new BufferedOutputStream(new FileOutputStream("copy.dat"));

            byte[] buffer = new byte[4096];
            int bytes;

            while ((bytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);
            }

            in.close();
            out.close();
            System.out.println("Copy completed");

        } catch (IOException e) {
            System.out.println("File not found. Check file path.");
        }
    }
}
