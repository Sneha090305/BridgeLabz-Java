package linearbinary;
import java.io.*;

class perfTest {

    static void testBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        long st = System.nanoTime();
        for (int i = 0; i < n; i++)
            sb.append("hello");
        long et = System.nanoTime();
        System.out.println("StringBuilder time: " + (et - st));
    }

    static void testBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        long st = System.nanoTime();
        for (int i = 0; i < n; i++)
            sb.append("hello");
        long et = System.nanoTime();
        System.out.println("StringBuffer time: " + (et - st));
    }

    static void readWithFileReader(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        long st = System.nanoTime();
        long wc = 0;
        String line;
        while ((line = br.readLine()) != null)
            wc += line.trim().isEmpty() ? 0 : line.split("\\s+").length;
        long et = System.nanoTime();
        br.close();
        System.out.println("FileReader words: " + wc);
        System.out.println("FileReader time: " + (et - st));
    }

    static void readWithInputStreamReader(String path) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), "UTF-8"));
        long st = System.nanoTime();
        long wc = 0;
        String line;
        while ((line = br.readLine()) != null)
            wc += line.trim().isEmpty() ? 0 : line.split("\\s+").length;
        long et = System.nanoTime();
        br.close();
        System.out.println("InputStreamReader words: " + wc);
        System.out.println("InputStreamReader time: " + (et - st));
    }

    public static void main(String[] args) throws Exception {
        int n = 1_000_000;
        String path = "C:\\Users\\MAHA\\BridgeLabz_Java_CG\\src\\input.txt";

        testBuilder(n);
        testBuffer(n);

        readWithFileReader(path);
        readWithInputStreamReader(path);
    }
}
