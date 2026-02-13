package csvhandling;

import java.io.*;
import java.util.Base64;

public class CsvEncryptWrite {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new FileWriter("secure.csv"));

        bw.write("Name,EmailEncrypted");
        bw.newLine();

        writeRow(bw, "Amit", "amit@gmail.com");
        writeRow(bw, "Riya", "riya@gmail.com");

        bw.close();
        System.out.println("Encrypted CSV written.");
    }

    static void writeRow(BufferedWriter bw, String name, String email) throws Exception {
        String enc = Base64.getEncoder().encodeToString(email.getBytes());
        bw.write(name + "," + enc);
        bw.newLine();
    }
}