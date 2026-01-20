package dsa.linkedlist;

import java.util.Scanner;

class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;

    ProcessNode(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

public class RoundRobinScheduling {

    private ProcessNode head;

    public void addProcess(int pid, int burstTime) {
        ProcessNode newNode = new ProcessNode(pid, burstTime);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        ProcessNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    public void schedule(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes available");
            return;
        }

        int time = 0;
        int completed = 0;
        int totalWaiting = 0;
        int totalTurnaround = 0;

        ProcessNode temp = head;

        while (true) {
            boolean done = true;

            do {
                if (temp.remainingTime > 0) {
                    done = false;

                    if (temp.remainingTime > timeQuantum) {
                        time += timeQuantum;
                        temp.remainingTime -= timeQuantum;
                    } else {
                        time += temp.remainingTime;
                        temp.remainingTime = 0;
                        temp.turnaroundTime = time;
                        temp.waitingTime = temp.turnaroundTime - temp.burstTime;
                        totalWaiting += temp.waitingTime;
                        totalTurnaround += temp.turnaroundTime;
                        completed++;
                    }
                }
                temp = temp.next;
            } while (temp != head);

            if (done)
                break;
        }

        displayProcesses();
        int count = countProcesses();
        System.out.println("Average Waiting Time: " + (double) totalWaiting / count);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaround / count);
    }

    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        ProcessNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes available");
            return;
        }
        ProcessNode temp = head;
        System.out.println("\nPID  Burst  Waiting  Turnaround");
        do {
            System.out.println(
                    temp.pid + "     " +
                            temp.burstTime + "       " +
                            temp.waitingTime + "         " +
                            temp.turnaroundTime
            );
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoundRobinScheduling rr = new RoundRobinScheduling();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Process ID: ");
            int pid = sc.nextInt();
            System.out.print("Enter Burst Time: ");
            int burst = sc.nextInt();
            rr.addProcess(pid, burst);
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        rr.schedule(tq);

        sc.close();
    }
}
