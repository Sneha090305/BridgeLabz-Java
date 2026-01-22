package linearbinary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class readFile {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\MAHA\\BridgeLabz_Java_CG\\src\\input.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null)
            System.out.println(line);

        br.close();
        fr.close();
    }
}
