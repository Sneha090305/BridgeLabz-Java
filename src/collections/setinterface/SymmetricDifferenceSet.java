import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceSet {

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
        result.addAll(set2);   // union

        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2); // intersection

        result.removeAll(common);

        System.out.println("Symmetric Difference: " + result);
    }
}
