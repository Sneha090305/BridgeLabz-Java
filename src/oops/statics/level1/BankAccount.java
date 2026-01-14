package oops.statics.level1;

import java.util.Scanner;

public class BankAccount {

    static String bankName = "ABC Bank";
    static int totalAccounts = 0;

    private String accountHolderName;
    private final int accountNumber;

    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void display(Object obj) {
        if (obj instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Holder   : " + accountHolderName);
            System.out.println("Acc No   : " + accountNumber);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount("Sneha", 101);
        acc.display(acc);
        getTotalAccounts();
        sc.close();
    }
}
