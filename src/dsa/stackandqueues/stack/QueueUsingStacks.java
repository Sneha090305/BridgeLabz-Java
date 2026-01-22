package dsa.stackandqueues.stack;

import java.util.Scanner;
import java.util.Stack;

class QueueUsingStacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int x) {
        stack1.push(x);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks q = new QueueUsingStacks();

        System.out.print("Enter number of elements to enqueue: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            q.enqueue(sc.nextInt());
        }

        System.out.print("Enter number of dequeue operations: ");
        int d = sc.nextInt();

        for (int i = 0; i < d; i++) {
            System.out.println("Dequeued: " + q.dequeue());
        }

        sc.close();
    }
}
