package coreprogramming.string.level2;

public class StudentGrade {

    public static String grade(double p) {
        if (p >= 80) return "A";
        if (p >= 70) return "B";
        if (p >= 60) return "C";
        if (p >= 50) return "D";
        if (p >= 40) return "E";
        return "R";
    }

    public static void main(String[] args) {

        int students = 5;

        System.out.println("P C M Total % Grade");

        for (int i = 0; i < students; i++) {
            int p = (int)(Math.random() * 90) + 10;
            int c = (int)(Math.random() * 90) + 10;
            int m = (int)(Math.random() * 90) + 10;

            int total = p + c + m;
            double percent = Math.round((total / 300.0) * 100);

            System.out.println(p + " " + c + " " + m + " " + total + " " + percent + " " + grade(percent));
        }
    }
}

