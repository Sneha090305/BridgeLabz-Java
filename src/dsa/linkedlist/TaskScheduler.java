package dsa.linkedlist;

import java.util.Scanner;

class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {

    private TaskNode head;
    private TaskNode current;

    public void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }
        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    public void removeByTaskId(int id) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        do {
            if (temp.taskId == id) {
                if (prev == null) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task removed");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }
        displayTask(current);
        current = current.next;
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No task with given priority");
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }
        TaskNode temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    private void displayTask(TaskNode t) {
        System.out.println("Task ID   : " + t.taskId);
        System.out.println("Task Name : " + t.taskName);
        System.out.println("Priority  : " + t.priority);
        System.out.println("Due Date  : " + t.dueDate);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n1 Add at Beginning");
            System.out.println("2 Add at End");
            System.out.println("3 Remove by Task ID");
            System.out.println("4 View Current Task");
            System.out.println("5 Search by Priority");
            System.out.println("6 Display All Tasks");
            System.out.println("0 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0)
                break;

            int id, priority;
            String name, date;

            switch (choice) {
                case 1:
                    System.out.print("Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    date = sc.nextLine();
                    scheduler.addAtBeginning(id, name, priority, date);
                    break;

                case 2:
                    System.out.print("Task ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Task Name: ");
                    name = sc.nextLine();
                    System.out.print("Priority: ");
                    priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: ");
                    date = sc.nextLine();
                    scheduler.addAtEnd(id, name, priority, date);
                    break;

                case 3:
                    System.out.print("Task ID: ");
                    id = sc.nextInt();
                    scheduler.removeByTaskId(id);
                    break;

                case 4:
                    scheduler.viewCurrentTask();
                    break;

                case 5:
                    System.out.print("Priority: ");
                    priority = sc.nextInt();
                    scheduler.searchByPriority(priority);
                    break;

                case 6:
                    scheduler.displayAll();
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
