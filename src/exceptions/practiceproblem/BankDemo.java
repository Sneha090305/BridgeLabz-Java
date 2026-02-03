import java.util.Scanner;


class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}


class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}


public class BankDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount acc = new BankAccount(1000);

        try {
            System.out.print("Enter withdrawal amount: ");
            double amt = sc.nextDouble();

            acc.withdraw(amt);
        }

        catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance!");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        }

        finally {
            sc.close();
        }
    }
}
