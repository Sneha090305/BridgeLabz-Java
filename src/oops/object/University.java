import java.util.*;

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class Department {
    String name;

    Department(String name) {
        this.name = name;
    }
}

public class University {
    List<Department> departments = new ArrayList<>();
    List<Faculty> faculties = new ArrayList<>();

    void addDepartment(Department d) {
        departments.add(d);
    }

    void addFaculty(Faculty f) {
        faculties.add(f);
    }

    void deleteUniversity() {
        departments.clear();
        System.out.println("University deleted. Departments removed.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        University u = new University();

        System.out.print("Enter department name: ");
        u.addDepartment(new Department(sc.nextLine()));

        System.out.print("Enter faculty name: ");
        u.addFaculty(new Faculty(sc.nextLine()));

        u.deleteUniversity();
    }
}
