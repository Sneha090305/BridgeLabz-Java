package linearbinary;

import java.io.*;

class readByteChar {

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\MAHA\\BridgeLabz_Java_CG\\src\\input.txt";

        FileInputStream fs = new FileInputStream(path);
        InputStreamReader ir = new InputStreamReader(fs, "UTF-8");
        BufferedReader br = new BufferedReader(ir);

        String line;
        while ((line = br.readLine()) != null)
            System.out.println(line);

        br.close();
        ir.close();
        fs.close();
    }
}

