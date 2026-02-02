import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {

        try {

            DataOutputStream out =
                    new DataOutputStream(new FileOutputStream("student.dat"));

            out.writeInt(101);
            out.writeUTF("Sneha");
            out.writeDouble(8.75);
            out.close();

            System.out.println("Data written");

            DataInputStream in =
                    new DataInputStream(new FileInputStream("student.dat"));

            int roll = in.readInt();
            String name = in.readUTF();
            double gpa = in.readDouble();
            in.close();

            System.out.println("Roll: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("Stream error occurred");
        }
    }
}
