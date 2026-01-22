package linearbinary;

import java.util.HashSet;
import java.util.Set;

class removeDupli{

    static String uniq(String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> st = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!st.contains(c)) {
                st.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "programming";
        System.out.println(uniq(s));
    }
}
