import java.util.Scanner;

public class EducationalCourseHierarchy {

    static class Course {
        String courseName;
        int duration;

        Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }
    }

    static class OnlineCourse extends Course {
        String platform;
        boolean isRecorded;

        OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        double fee;
        double discount;

        PaidOnlineCourse(String courseName, int duration, String platform,
                         boolean isRecorded, double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        double calculateFinalFee() {
            return fee - (fee * discount / 100);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String name = sc.nextLine();

        System.out.print("Enter duration (days): ");
        int duration = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter platform: ");
        String platform = sc.nextLine();

        System.out.print("Is recorded? (true/false): ");
        boolean recorded = sc.nextBoolean();

        System.out.print("Enter course fee: ");
        double fee = sc.nextDouble();

        System.out.print("Enter discount percentage: ");
        double discount = sc.nextDouble();

        PaidOnlineCourse course =
                new PaidOnlineCourse(name, duration, platform, recorded, fee, discount);
        System.out.println("\n--- Course Details ---");
        System.out.println("Course Name: " + course.courseName);
        System.out.println("Final Fee: " + course.calculateFinalFee());

        sc.close();
    }
}
