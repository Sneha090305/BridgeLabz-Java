import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    String getEvaluationType() {
        return "Exam Based Course";
    }
}

class AssignmentCourse extends CourseType {
    String getEvaluationType() {
        return "Assignment Based Course";
    }
}

class ResearchCourse extends CourseType {
    String getEvaluationType() {
        return "Research Based Course";
    }
}

class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() {
        return courseType;
    }
}

public class UniversityCourseSystem {

    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println(c.getEvaluationType());
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> examCourse =
                new Course<>(new ExamCourse());

        Course<AssignmentCourse> assignmentCourse =
                new Course<>(new AssignmentCourse());

        Course<ResearchCourse> researchCourse =
                new Course<>(new ResearchCourse());

        List<CourseType> courseList = new ArrayList<>();
        courseList.add(examCourse.getCourseType());
        courseList.add(assignmentCourse.getCourseType());
        courseList.add(researchCourse.getCourseType());

        displayCourses(courseList);
    }
}
