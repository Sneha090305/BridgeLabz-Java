package dsa.linkedlist;

import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class UndoRedoEditor {

    private TextState head;
    private TextState current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String text) {
        TextState newState = new TextState(text);

        if (head == null) {
            head = current = newState;
            size = 1;
            return;
        }

        current.next = null;
        newState.prev = current;
        current.next = newState;
        current = newState;
        size++;

        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public void showCurrent() {
        if (current == null) {
            System.out.println("Editor is empty");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UndoRedoEditor editor = new UndoRedoEditor();

        while (true) {
            System.out.println("\n1 Type Text");
            System.out.println("2 Undo");
            System.out.println("3 Redo");
            System.out.println("4 Show Current Text");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0)
                break;

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.showCurrent();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
