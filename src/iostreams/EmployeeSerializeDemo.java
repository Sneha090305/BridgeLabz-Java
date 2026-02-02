import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class EmployeeSerializeDemo {
    public static void main(String[] args) {

        try {

            List<Employee> list = new ArrayList<>();
            list.add(new Employee(1, "Sneha", "AI", 50000));
            list.add(new Employee(2, "Rahul", "Cloud", 60000));

            //  Serialize
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("emp.dat"));
            out.writeObject(list);
            out.close();
            System.out.println("Employees saved");

            // 🔸 Deserialize
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("emp.dat"));
            List<Employee> readList =
                    (List<Employee>) in.readObject();
            in.close();

            for (Employee e : readList) {
                System.out.println(e.id + " " + e.name +
                        " " + e.dept + " " + e.salary);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error in serialization");
        }
    }
}
