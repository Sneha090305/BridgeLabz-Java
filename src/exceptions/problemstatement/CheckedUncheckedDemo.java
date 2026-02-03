
class DataProcessingException extends Exception {
    public DataProcessingException(String message) {
        super(message);
    }
}

public class CheckedUncheckedDemo {

    static void processData(String data, int value)
            throws DataProcessingException {


        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }

        if (data == null || data.isEmpty()) {
            throw new DataProcessingException("Data is missing");
        }

        System.out.println("Processing successful → " + data + ", " + value);
    }

    public static void main(String[] args) {

        try {
            processData("", 10);   // change inputs to test cases
        }

        catch (DataProcessingException e) {
            System.out.println("Checked exception handled: " + e.getMessage());
        }

        catch (IllegalArgumentException e) {
            System.out.println("Unchecked exception handled: " + e.getMessage());
        }

        finally {
            System.out.println("Program finished");
        }
    }
}
