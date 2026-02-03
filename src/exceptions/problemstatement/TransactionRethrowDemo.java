
class TransactionException extends Exception {
    public TransactionException(String message) {
        super(message);
    }
}

public class TransactionRethrowDemo {

    static void processTransaction(double amount) throws TransactionException {

        if (amount <= 0) {
            throw new TransactionException("Amount must be greater than zero");
        }

        if (amount > 5000) {
            throw new TransactionException("Amount exceeds transaction limit");
        }

        System.out.println("Transaction processed successfully: " + amount);
    }


    static void handleTransaction(String txnId, double amount)
            throws TransactionException {

        try {
            processTransaction(amount);
        }

        catch (TransactionException e) {

            throw new TransactionException(
                    "Transaction " + txnId + " failed → " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        try {
            handleTransaction("TXN-101", 7000);
        }

        catch (TransactionException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
