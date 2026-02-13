package csvhandling;

import java.io.*;
import java.util.Base64;

public class CsvDecryptRead {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("secure.csv"));

        br.readLine(); // skip header

        String line;

        while ((line = br.readLine()) != null) {

            String[] d = line.split(",");

            String decrypted = new String(
                    Base64.getDecoder().decode(d[1])
            );

            System.out.println(d[0] + " → " + decrypted);
        }

        br.close();
    }
}