import java.util.LinkedList;
import java.util.Scanner;

class CustomHashMap {

    class Entry {
        int key, value;
        Entry(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int SIZE = 10;
    private LinkedList<Entry>[] table = new LinkedList[SIZE];

    public void put(int key, int value) {
        int index = key % SIZE;
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        table[index].add(new Entry(key, value));
    }

    public Integer get(int key) {
        int index = key % SIZE;
        if (table[index] != null) {
            for (Entry e : table[index]) {
                if (e.key == key) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap map = new CustomHashMap();

        System.out.print("Enter number of key-value pairs: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter key for entry " + (i + 1) + ": ");
            int key = sc.nextInt();

            System.out.print("Enter value for key " + key + ": ");
            int value = sc.nextInt();

            map.put(key, value);
        }

        System.out.print("Enter key to search: ");
        int searchKey = sc.nextInt();

        Integer result = map.get(searchKey);

        if (result != null) {
            System.out.println("Value found: " + result);
        } else {
            System.out.println("Key not found");
        }

        sc.close();
    }
}
