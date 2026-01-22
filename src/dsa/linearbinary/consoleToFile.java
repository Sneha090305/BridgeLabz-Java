package linearbinary;

import java.io.*;

class consoleToFile {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("C:\\Users\\MAHA\\BridgeLabz_Java_CG\\src\\output.txt");

        String line;
        while (true) {
            line = br.readLine();
            if (line.equalsIgnoreCase("exit"))
                break;
            fw.write(line + "\n");
        }

        fw.close();
        br.close();
    }
}
