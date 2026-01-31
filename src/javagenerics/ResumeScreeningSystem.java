import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    String getRoleName() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private T role;

    public Resume(T role) {
        this.role = role;
    }

    public T getRole() {
        return role;
    }
}

public class ResumeScreeningSystem {

    public static void screenResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening resume for: " + role.getRoleName());
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume =
                new Resume<>(new SoftwareEngineer());

        Resume<DataScientist> dsResume =
                new Resume<>(new DataScientist());

        Resume<ProductManager> pmResume =
                new Resume<>(new ProductManager());


        List<JobRole> roleList = new ArrayList<>();
        roleList.add(seResume.getRole());
        roleList.add(dsResume.getRole());
        roleList.add(pmResume.getRole());

        screenResumes(roleList);
    }
}
