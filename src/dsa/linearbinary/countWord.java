package linearbinary;

import java.io.*;

class countWord {

    static int count(String path, String key) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        int c = 0;
        String line;

        while ((line = br.readLine()) != null) {
            for (String s : line.toLowerCase().split("\\W+"))
                if (s.equals(key.toLowerCase()))
                    c++;
        }
        br.close();
        return c;
    }

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\MAHA\\BridgeLabz_Java_CG\\src\\input.txt";
        System.out.println(count(path, "java"));
    }
}

