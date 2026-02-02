import java.io.*;

public class PipedStreamDemo {

    public static void main(String[] args) {

        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writer = new Thread(() -> {
                try {
                    pos.write("Hello Piped Stream".getBytes());
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Write error");
                }
            });

            Thread reader = new Thread(() -> {
                try {
                    int ch;
                    while ((ch = pis.read()) != -1) {
                        System.out.print((char) ch);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Read error");
                }
            });

            writer.start();
            reader.start();

        } catch (IOException e) {
            System.out.println("Pipe connection error");
        }
    }
}
