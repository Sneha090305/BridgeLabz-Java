package oops.encapsulation;

import java.util.Scanner;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {

    private int accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : " + balance);
        System.out.println("Interest       : " + calculateInterest());
    }
}

class SavingsAccount extends BankAccount implements Loanable {

    private double loanAmount;

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }

    public void applyForLoan(double amount) {
        loanAmount = amount;
    }

    public boolean calculateLoanEligibility() {
        return balance >= 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {

    private double loanAmount;

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    public double calculateInterest() {
        return balance * 0.02;
    }

    public void applyForLoan(double amount) {
        loanAmount = amount;
    }

    public boolean calculateLoanEligibility() {
        return balance >= 10000;
    }
}

public class BankAccountMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose Account Type: ");
        int choice = sc.nextInt();

        BankAccount account;

        if (choice == 1) {
            account = new SavingsAccount(accNo, name, balance);
        } else {
            account = new CurrentAccount(accNo, name, balance);
        }

        System.out.print("Enter deposit amount: ");
        account.deposit(sc.nextDouble());

        System.out.print("Enter withdrawal amount: ");
        account.withdraw(sc.nextDouble());

        System.out.println("\n---- Account Details ----");
        account.displayDetails();

        sc.close();
    }
}
