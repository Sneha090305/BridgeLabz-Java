import java.io.*;

public class ImageByteArrayCopy {
    public static void main(String[] args) {

        try {

            FileInputStream in = new FileInputStream("input.jpg");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int data;
            while ((data = in.read()) != -1) {
                bos.write(data);
            }

            byte[] imgBytes = bos.toByteArray();
            in.close();


            ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
            FileOutputStream out = new FileOutputStream("output.jpg");

            while ((data = bis.read()) != -1) {
                out.write(data);
            }

            out.close();
            System.out.println("Image copied successfully");

        } catch (IOException e) {
            System.out.println("Error processing image");
        }
    }
}
