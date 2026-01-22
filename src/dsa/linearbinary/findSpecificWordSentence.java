package linearbinary;

public class findSpecificWordSentence {
    static String find(String[] a, String key) {
        for (String s : a)
            if (s.toLowerCase().contains(key.toLowerCase()))
                return s;
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] a = {
                "Java is powerful",
                "I love programming",
                "Linear search is simple",
                "Data structures are important"
        };

        System.out.println(find(a, "search"));
    }
}

