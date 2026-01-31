import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);

        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);

        result.removeAll(common);

        System.out.println(result);
    }
}
