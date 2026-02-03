
class FakeConnection {

    public void open() {
        System.out.println("Connection opened");
    }

    public void sendData(String data) {
        if (data == null) {
            throw new RuntimeException("Data cannot be null");
        }
        System.out.println("Data sent: " + data);
    }

    public void close() {
        System.out.println("Connection closed");
    }
}

public class ResourceCleanupDemo {

    public static void main(String[] args) {

        FakeConnection conn = new FakeConnection();

        try {
            conn.open();


            String payload = null;

            conn.sendData(payload);
        }

        catch (RuntimeException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }

        finally {

            conn.close();
            System.out.println("Cleanup done");
        }
    }
}
