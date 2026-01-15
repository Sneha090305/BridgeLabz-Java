import java.util.*;

class Patient {
    String name;

    Patient(String name) {
        this.name = name;
    }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        patients.add(p);
        System.out.println("Doctor " + name + " consulted " + p.name);
    }
}

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter doctor name: ");
        Doctor d = new Doctor(sc.nextLine());

        System.out.print("Enter patient name: ");
        Patient p = new Patient(sc.nextLine());

        d.consult(p);
    }
}
