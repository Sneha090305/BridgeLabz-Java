import java.io.*;
import java.util.*;

public class WordFrequencyTop5 {

    public static void main(String[] args) {


        String path = "text.txt";

        HashMap<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = br.readLine()) != null) {

                // normalize text
                line = line.toLowerCase();
                line = line.replaceAll("[^a-z ]", " ");

                String[] words = line.split("\\s+");

                for (String w : words) {
                    if (!w.isEmpty()) {
                        wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + path);
            return;
        } catch (IOException e) {
            System.out.println("Error reading file");
            return;
        }


        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCount.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 5 words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            Map.Entry<String, Integer> e = list.get(i);
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }
}
