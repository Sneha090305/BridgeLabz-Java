import java.util.Scanner;
import java.util.Stack;

class SortStack {

    static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }

    static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        sortStack(stack);

        System.out.println("Sorted Stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        sc.close();
    }
}
