import java.util.Scanner;

public class BankAccountTypes {

    static class BankAccount {
        int accountNumber;
        double balance;

        BankAccount(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
    }

    static class SavingsAccount extends BankAccount {
        double interestRate;

        SavingsAccount(int accNo, double bal, double interestRate) {
            super(accNo, bal);
            this.interestRate = interestRate;
        }

        void displayAccountType() {
            System.out.println("Account Type: Savings Account");
        }
    }

    static class CheckingAccount extends BankAccount {
        double withdrawalLimit;

        CheckingAccount(int accNo, double bal, double withdrawalLimit) {
            super(accNo, bal);
            this.withdrawalLimit = withdrawalLimit;
        }

        void displayAccountType() {
            System.out.println("Account Type: Checking Account");
        }
    }

    static class FixedDepositAccount extends BankAccount {
        int tenure;

        FixedDepositAccount(int accNo, double bal, int tenure) {
            super(accNo, bal);
            this.tenure = tenure;
        }

        void displayAccountType() {
            System.out.println("Account Type: Fixed Deposit Account");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        System.out.println("Choose account type:");
        System.out.println("1. Savings");
        System.out.println("2. Checking");
        System.out.println("3. Fixed Deposit");
        int choice = sc.nextInt();

        BankAccount account;

        if (choice == 1) {
            System.out.print("Enter interest rate: ");
            double rate = sc.nextDouble();
            account = new SavingsAccount(accNo, balance, rate);
            ((SavingsAccount) account).displayAccountType();

        } else if (choice == 2) {
            System.out.print("Enter withdrawal limit: ");
            double limit = sc.nextDouble();
            account = new CheckingAccount(accNo, balance, limit);
            ((CheckingAccount) account).displayAccountType();

        } else {
            System.out.print("Enter tenure (years): ");
            int tenure = sc.nextInt();
            account = new FixedDepositAccount(accNo, balance, tenure);
            ((FixedDepositAccount) account).displayAccountType();
        }

        sc.close();
    }
}
